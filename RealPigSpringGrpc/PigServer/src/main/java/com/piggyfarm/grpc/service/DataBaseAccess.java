package com.piggyfarm.grpc.service;

import com.pigfarm.pig.PigObject;
import com.pigfarm.pig.ProductObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseAccess {

    private String sName = "PigReg";
    private Connection Connect()
    {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5433/postgres",
                            "postgres", "9097");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;

    }

    public List<PigObject> getPigsFromProduct(int productId)
    {
        Connection c = Connect();
        String statement = "SELECT  pig.id, pig.weight FROM \"PigReg\".pig " +
                "INNER JOIN \"PigReg\".part on part.pigId = pig.id " +
                "INNER JOIN \"PigReg\".product on product.id = part.productId " +
                "where product.id = " + productId + ";";
        List<PigObject> pigs = new ArrayList<>();
        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet pigInProductResult = getPigsInProduct.executeQuery();
            if (pigInProductResult != null)
                while (pigInProductResult.next())
                {
                    PigObject obj = PigObject.newBuilder()
                            .setId(Integer.parseInt(pigInProductResult.getString("id")))
                            .setWeight(pigInProductResult.getDouble("weight"))
                            .build();
                    pigs.add(obj);
                }
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pigs;
    }

    public List<ProductObject> getProductFromPigs(int pigId)
    {
        Connection c = Connect();
        String statement = "SELECT  product.id, product.name, (Select sum(pa.weight) as weight from \"PigReg\".product as pu " +
                "inner join \"PigReg\".part as pa on pa.productId = pu.id where pu.id = product.id) FROM \"PigReg\".product " +
                "INNER JOIN \"PigReg\".part on part.productId = product.id " +
                "INNER JOIN \"PigReg\".pig on part.pigId = pig.id " +
                "where pig.id = " + pigId +
                " group by product.id;";
        List<ProductObject> products = new ArrayList<>();
        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet productFromPigResult = getPigsInProduct.executeQuery();
            if (productFromPigResult != null)
                while (productFromPigResult.next())
                {
                    ProductObject obj = ProductObject.newBuilder()
                            .setId(Integer.parseInt(productFromPigResult.getString("id")))
                            .setWeight(Double.parseDouble(productFromPigResult.getString("weight")))
                            .build();
                    products.add(obj);
                }
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public PigObject registerPig(double weight)
    {
        Connection c = Connect();
        String statement = "INSERT INTO \"PigReg\".pig(weight)\n values (" + weight +") RETURNING *;";
        PigObject pig = null;
        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet productFromPigResult = getPigsInProduct.executeQuery();
            if (productFromPigResult != null)
                while (productFromPigResult.next())
                {
                    pig = PigObject.newBuilder()
                            .setId(productFromPigResult.getString("id"))
                            .setWeight(Double.parseDouble(productFromPigResult.getString("weight")))
                            .build();
                }
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pig;
    }

    public PigObject registerPigParts(TempPigParts temp)
    {
        Connection c = Connect();
        String statement = "insert into \"PigReg\".part (weight, pigid, trayid, name) values ";

        int i = 1;
        for ( TempPigPart part:temp.getParts()) {
            statement += "(" + part.getWeight() + ", " + part.getPigId() + ", '"
                    + temp.getTrayId() + "', '" + part.getName() + "')";
            if(i++ != temp.getParts().size()){
                System.out.println("yo");
                statement += ", ";
            }
        }
        statement += " RETURNING *;";
        System.out.println(statement);
        PigObject pig = null;
        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet productFromPigResult = getPigsInProduct.executeQuery();
            if (productFromPigResult != null)
                while (productFromPigResult.next())
                {
                    System.out.println(productFromPigResult.getString("id"));
                    /*pig = PigObject.newBuilder()
                            .setId(productFromPigResult.getString("id"))
                            .setWeight(Double.parseDouble(productFromPigResult.getString("weight")))
                            .build();*/
                }
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pig;
    }

    public PigObject registerProduct(TempPackagething temp)
    {
        Connection c = Connect();
        String statement = "INSERT INTO \"PigReg\".product (name) Values ('"+ temp.getName() +"') RETURNING *;";

        int packageId;

        try {
            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet productFromPigResult = getPigsInProduct.executeQuery();
            productFromPigResult.next();
            packageId = productFromPigResult.getInt("id");
            System.out.println(packageId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        statement = "UPDATE \"PigReg\".part SET productid = "+packageId+" where id in (";
        int i = 1;

        for ( TempPigPart part:temp.getParts()) {
            statement += part.getId();
            if(i++ != temp.getParts().size())
                statement += ", ";
        }

        statement += ") RETURNING *;";

        PigObject pig = null;
        try {
            System.out.println("got here 5");

            PreparedStatement getPigsInProduct = c.prepareStatement(statement);
            ResultSet productFromPigResult = getPigsInProduct.executeQuery();
            if (productFromPigResult != null)
                while (productFromPigResult.next())
                {
                    System.out.println("got here 3");

                    System.out.println(productFromPigResult.getString("productid"));
                    /*pig = PigObject.newBuilder()
                            .setId(productFromPigResult.getString("id"))
                            .setWeight(Double.parseDouble(productFromPigResult.getString("weight")))
                            .build();*/
                }
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pig;
    }
}