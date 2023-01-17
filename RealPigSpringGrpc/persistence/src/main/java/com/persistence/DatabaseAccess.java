package com.persistence;

import com.domain.*;
import com.domain.dtos.RegisterPartDto;
import com.domain.dtos.RegisterPigDto;
import com.domain.dtos.RegisterProductDto;
import com.domain.dtos.RegisterTrayDto;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess implements RegisterDataAccess, AgentDataAccess {

    private String sName = "\"PigReg\"";
    private Connection Connect()
    {
        Connection c;
        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5433/postgres",
                            "postgres", "9097");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;

    }

    public List<Pig> getPigsFromProduct(int productId)
    {
        Connection c = Connect();

        String statement = "SELECT  pig.id, pig.weight FROM "+ sName +".pig " +
                "INNER JOIN "+ sName +".part on part.pigId = pig.id " +
                "INNER JOIN "+ sName +".product on product.id = part.productId " +
                "where product.id = " + productId + ";";

        List<Pig> pigs = new ArrayList<>();

        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet pigInProductResult = getPigsInProduct.executeQuery();

            if (pigInProductResult != null) {
                while (pigInProductResult.next())
                {
                    Pig pig = new Pig(
                            pigInProductResult.getInt("id"),
                            pigInProductResult.getDouble("weight")
                    );

                    pigs.add(pig);
                }
            }

            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pigs;
    }

    public List<Product> getProductFromPigs(int pigId)
    {
        Connection c = Connect();

        String statement = "SELECT  product.id, product.name, (Select sum(pa.weight) as weight from "+ sName +".product as pu " +
                "inner join "+ sName +".part as pa on pa.productId = pu.id where pu.id = product.id) FROM "+ sName +".product " +
                "INNER JOIN "+ sName +".part on part.productId = product.id " +
                "INNER JOIN "+ sName +".pig on part.pigId = pig.id " +
                "where pig.id = " + pigId +
                " group by product.id;";

        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet productFromPigResult = getPigsInProduct.executeQuery();

            if (productFromPigResult != null) {
                while (productFromPigResult.next())
                {
                    Product product = new Product(
                        productFromPigResult.getInt("id"),
                        productFromPigResult.getDouble("weight")
                    );

                    products.add(product);
                }
            }

            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public Pig registerPig(RegisterPigDto pigDto)
    {
        double weight = pigDto.getWeight();

        Connection c = Connect();

        String statement = "INSERT INTO "+ sName +".pig(weight, origin)\n values (" + weight + ", '" + pigDto.getOrigin() + "') RETURNING *;";

        Pig pig = null;

        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet productFromPigResult = getPigsInProduct.executeQuery();
            if (productFromPigResult != null) {
                while (productFromPigResult.next())
                {
                    pig = new Pig(
                        productFromPigResult.getInt("id"),
                        productFromPigResult.getDouble("weight")
                    );
                }
            }

            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pig;
    }

    public Tray registerTray(RegisterTrayDto registerTrayDto) {
        Connection c = Connect();

        String statement = "insert into "+ sName +".part (weight, pigid, trayid, name) values ";

        int i = 1;

        for (RegisterPartDto part : registerTrayDto.getParts()) {
            statement += "(" + part.getWeight() + ", " + part.getPigId() + ", '"
                    + registerTrayDto.getTrayId() + "', '" + part.getPartType() + "')";

            if (i++ != registerTrayDto.getParts().size()) {
                statement += ", ";
            }
        }

        statement += " RETURNING *;";

        try {
            PreparedStatement toBeRegisteredParts = c.prepareStatement(statement);
            ResultSet registeredParts = toBeRegisteredParts.executeQuery();

            if (registeredParts != null)
            {
                List<Part> parts = new ArrayList<>();

                while (registeredParts.next())
                {
                    Part part = new Part(
                            registeredParts.getInt("id"),
                            registeredParts.getDouble("weight"),
                            registeredParts.getInt("pigId"),
                            PigPartType.valueOf(registeredParts.getString("name"))
                    );

                    parts.add(part);
                }

                c.close();

                return new Tray(registerTrayDto.getTrayId(), parts, registerTrayDto.getWeight(), registerTrayDto.getPartType());
            }

            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException();
    }

    public Product registerProduct(RegisterProductDto registerProductDto)
    {
        Connection c = Connect();
        String statement = "INSERT INTO "+ sName +".product (name) Values ('Produkt Navn') RETURNING *;";

        int packageId;

        try {
            PreparedStatement productToBeRegistered = c.prepareStatement(statement);
            ResultSet registeredProduct = productToBeRegistered.executeQuery();
            registeredProduct.next();

            packageId = registeredProduct.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        statement = "UPDATE "+ sName +".part SET productid = "+packageId+" where id in (";
        int i = 1;

        for (Part part : registerProductDto.getParts()) {
            statement += part.getId();

            if (i++ != registerProductDto.getParts().size()) {
                statement += ", ";
            }
        }

        statement += ") RETURNING *;";

        Product product = new Product(
                packageId,
                registerProductDto.getWeight(),
                registerProductDto.getParts()
        );

        PreparedStatement toBeRegisteredParts = null;

        try {
            toBeRegisteredParts = c.prepareStatement(statement);
            toBeRegisteredParts.executeQuery();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    public List<Pig> getFromOrigin(String origin)
    {
        Connection c = Connect();
        String statement = "SELECT * FROM "+ sName +".pig WHERE origin = '" + origin + "';";
        return getPigs(c, statement);
    }

    public List<Pig> getFromDate(LocalDate date)
    {
        Connection c = Connect();
        String statement = "SELECT * FROM "+ sName +".pig WHERE date = '" + date + "';";
        return getPigs(c, statement);
    }

    private List<Pig> getPigs(Connection c, String statement) {
        List<Pig> toReturn = new ArrayList<>();
        try {
            PreparedStatement productToBeRegistered = c.prepareStatement(statement);
            ResultSet registeredProduct = productToBeRegistered.executeQuery();

            while (registeredProduct.next())
            {
                toReturn.add(
                    new Pig(registeredProduct.getInt("id"),
                            registeredProduct.getDouble("weight"),
                            registeredProduct.getString("origin"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toReturn;
    }
}








// parking
/*try {
            PreparedStatement toBeRegisteredParts = c.prepareStatement(statement);
            ResultSet registeredParts = toBeRegisteredParts.executeQuery();
            if (registeredParts != null)
            {
                List<RegisteredPartObject> parts = new ArrayList<>();
                while (registeredParts.next())
                {
                    RegisteredPartObject part = RegisteredPartObject.newBuilder()
                            .setPigId(registeredParts.getInt("pig_id"))
                            .setWeight(registeredParts.getInt("weight"))
                            .setPartType(registeredParts.getString("name"))
                            .setPartId(registeredParts.getInt("id"))
                            .build();

                    parts.add(part);
                }

                TrayResponse trayResponse = TrayResponse.newBuilder()
                        .setTrayId(temp.getTrayId())
                        .setWeight(temp.getWeight())
                        .addAllRegisteredParts(parts)
                        .build();

                c.close();
                return trayResponse;

                }
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

