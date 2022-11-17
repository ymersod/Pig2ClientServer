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
}
