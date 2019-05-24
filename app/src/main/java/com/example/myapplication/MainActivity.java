package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private Employee employee;
    private static final String url = "jdbc:mysql://localhost:3306/test_user";
    private static final String user = "viper";
    private static final String password = "Positron!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employee = new Employee();
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view){
        TextView textView = findViewById(R.id.text_res);
        EditText editText_name = findViewById(R.id.name_text);
        EditText editText_prenom = findViewById(R.id.prenom_text);
        EditText editText_age = findViewById(R.id.age_text);
        EditText editText_tel = findViewById(R.id.tel_text);

        employee.setNom(editText_name.getText().toString());
        employee.setPrenom(editText_prenom.getText().toString());
        String age = editText_age.getText().toString();
        employee.setAge(Integer.parseInt(age));
        employee.setTelephone(editText_tel.getText().toString());

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = null;
            String query = "insert into employee(name, prenom, telephone, age) values(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, employee.getNom());
            ps.setString(2, employee.getPrenom());
            ps.setString(3, employee.getTelephone());
            ps.setInt(4, employee.getAge());
            System.out.println(ps);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        textView.setText("Hello, my name is "+employee.getPrenom()+" "+employee.getNom()+", i am "+employee.getAge()+" and my number is "+employee.getTelephone());

    }

}
