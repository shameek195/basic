package sample;

import connectivity.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller2 {
//    public  Controller2(){
//


    public ComboBox comboBox1;
    public Label label;
    public Button m1;
    public Button m7;
    public Button m2;
    public Button m3;
    public Button m4;
    public Button m5;
    public Button m6;
    public Button t1;
    public Button t7;
    public Button t2;
    public Button t3;
    public Button t4;
    public Button t5;
    public Button t6;
    public Button w1;
    public Button w7;
    public Button w2;
    public Button w3;
    public Button w4;
    public Button w5;
    public Button w6;
    public Button th1;
    public Button th7;
    public Button th2;
    public Button th3;
    public Button th4;
    public Button th5;
    public Button th6;
    public Button f1;
    public Button f7;
    public Button f2;
    public Button f3;
    public Button f4;
    public Button f5;
    public Button f6;
    public ComboBox comboBox12;
    public ComboBox comboBox121;
    int count = 0;
    @FXML
    private AnchorPane rootpane1;
    public String buttoninfo;
    Statement statement, statement1, statement2;
    connectionClass connectionclass = new connectionClass();
    Connection connection = connectionclass.getConnection();
    ResultSet rs, rs1;
    int labflag=0;
    static ResultSet rscount;
    public static String name, str, name1, str1,subjcount,c;

    @FXML
    private void initialize() {

        try {
            String sql = "SELECT * FROM lecturers where SECTION ='A'";

            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            ObservableList<String> list = FXCollections.observableArrayList();
            ObservableList<String> list1 = FXCollections.observableArrayList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY");
            ObservableList<String> list2 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7");
//            comboBox12.setItems(list1);
//            comboBox121.setItems(list2);

            while (rs.next()) {

                list.addAll(rs.getString("subject"));


            }
            comboBox1.setItems(list);
            comboBox12.setItems(list1);
            comboBox121.setItems(list2);
            setValue();


        } catch (Exception e) {
            System.out.println(e.getMessage());


        }


    }

    public void setValue() throws SQLException {
        str = comboBox1.getValue().toString();
        System.out.println(str);

        String sql1 = "SELECT * FROM lecturers where subject='" + str + "' AND section ='A'";
        try {
            System.out.println(sql1);
            statement1 = connection.createStatement();
            rs = statement1.executeQuery(sql1);
            rs.next();
            name = rs.getString("faculty");
            label.setText(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void BACK1(ActionEvent actionEvent) {
        {
            Parent thirdView;
            try {
                thirdView = FXMLLoader.load(getClass().getResource("sample1.fxml"));
                Scene secondScene = new Scene(thirdView);
                Stage curStage = (Stage) rootpane1.getScene().getWindow();
                curStage.setScene(secondScene);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void assign(ActionEvent actionEvent) {
       if(true) {
           try { String sql = "INSERT INTO `timetable5a` (`day`, `hour`, `subject`, `faculty`, `section`) VALUES('" + comboBox12.getValue() + "', '" + comboBox121.getValue() + "', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
           subjcount = (String) comboBox1.getValue();
           Pattern p = Pattern.compile("LAB");
           Matcher m = p.matcher(subjcount);

           String sqlcheck = "SELECT `countof` FROM count WHERE subject='" + subjcount + "' AND section='A'";
           String sqlop = "UPDATE `count` SET `countof`=countof-1 WHERE subject='" + subjcount + "' AND section='A'";

               rscount = statement.executeQuery(sqlcheck);
               rscount.next();
               c = rscount.getString("countof");
               System.out.println(c);


           if (c.compareTo("0") == 0) {
               System.out.println("No of hours has been exceeded");
           } else {
               if (m.find()) {
                   labflag = 1;
                   String sqlab = "UPDATE `count` SET `countof`=1 WHERE subject='" + subjcount + "'AND section='A'";

                       statement = connection.createStatement();
                       statement.executeUpdate(sqlab);


               }



                   statement = connection.createStatement();
                   statement.executeUpdate(sql);
                   statement.executeUpdate(sqlop);


               if (comboBox12.getValue() == "MONDAY") {
                   if (comboBox121.getValue() == "1") {
                       if (labflag == 1) {
                           m1.setText(str + "\n" + name);
                           m2.setText(str + "\n" + name);
                           m3.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '2', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '3', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           m1.setText(str + "\n" + name);

                       }

                   }
                   if (comboBox121.getValue() == "2")
                       m2.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "3")
                       m3.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "4")
                       m4.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "5") {
                       if (labflag == 1) {
                           m5.setText(str + "\n" + name);
                           m6.setText(str + "\n" + name);
                           m7.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '6', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '7', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);


                       } else {
                           m5.setText(str + "\n" + name);

                       }

                   }
                   if (comboBox121.getValue() == "6")
                       m6.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "7")
                       m7.setText(str + "\n" + name);

               }
               if (comboBox12.getValue() == "TUESDAY") {
                   if (comboBox121.getValue() == "1") {
                       if (labflag == 1) {
                           t1.setText(str + "\n" + name);
                           t2.setText(str + "\n" + name);
                           t3.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '2', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '3', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           t1.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "2")
                       t2.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "3")
                       t3.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "4")
                       t4.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "5") {
                       if (labflag == 1) {
                           t5.setText(str + "\n" + name);
                           t6.setText(str + "\n" + name);
                           t7.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '6', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '7', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           t5.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "6")
                       t6.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "7")
                       t7.setText(str + "\n" + name);

               }
               if (comboBox12.getValue() == "WEDNESDAY") {
                   if (comboBox121.getValue() == "1") {
                       if (labflag == 1) {
                           w1.setText(str + "\n" + name);
                           w2.setText(str + "\n" + name);
                           w3.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '2', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '3', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           w1.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "2")
                       w2.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "3")
                       w3.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "4")
                       w4.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "5") {
                       if (labflag == 1) {
                           w5.setText(str + "\n" + name);
                           w6.setText(str + "\n" + name);
                           w7.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '6', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '7', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           w5.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "6")
                       w6.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "7")
                       w7.setText(str + "\n" + name);

               }
               if (comboBox12.getValue() == "THURSDAY") {
                   if (comboBox121.getValue() == "1") {
                       if (labflag == 1) {
                           th1.setText(str + "\n" + name);
                           th2.setText(str + "\n" + name);
                           th3.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '2', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '3', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           th1.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "2")
                       th2.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "3")
                       th3.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "4")
                       th4.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "5") {
                       if (labflag == 1) {
                           th5.setText(str + "\n" + name);
                           th6.setText(str + "\n" + name);
                           th7.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '6', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '7', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           th5.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "6")
                       th6.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "7")
                       th7.setText(str + "\n" + name);

               }
               if (comboBox12.getValue() == "FRIDAY") {
                   if (comboBox121.getValue() == "1") {
                       if (labflag == 1) {
                           f1.setText(str + "\n" + name);
                           f2.setText(str + "\n" + name);
                           f3.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '2', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '3', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           f1.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "2")
                       f2.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "3")
                       f3.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "4")
                       f4.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "5") {
                       if (labflag == 1) {
                           f5.setText(str + "\n" + name);
                           f6.setText(str + "\n" + name);
                           f7.setText(str + "\n" + name);
                           String query = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '6', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";
                           String query1 = "INSERT INTO `timetable5a`(`day`, `hour`, `subject`, `faculty`, `section`) VALUES ('" + comboBox12.getValue() + "', '7', '" + comboBox1.getValue() + "', '" + label.getText() + "', 'A');";

                               statement.executeUpdate(query);
                               statement.executeUpdate(query1);

                       } else {
                           f5.setText(str + "\n" + name);

                       }
                   }
                   if (comboBox121.getValue() == "6")
                       f6.setText(str + "\n" + name);
                   if (comboBox121.getValue() == "7")
                       f7.setText(str + "\n" + name);

               }
           }} catch (SQLException e) {
               e.printStackTrace();
           }

       }else{}
    }

    public void refresh() {
            try {
                String sql3 = "SELECT * FROM timetable5a WHERE day='MONDAY' AND hour='1'";

                statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);

                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                Pattern p = Pattern.compile("LAB");
                Matcher m = p.matcher(name1);
                if (m.find()) {
                    System.out.println("matched");
                    m1.setText(name1 + "\n" + str1);
                    m2.setText(name1 + "\n" + str1);
                    m3.setText(name1 + "\n" + str1);

                } else {
                    m1.setText(name1 + "\n" + str1);
                }
                System.out.println("1");


                blabel:
                {
                    sql3 = "SELECT * FROM timetable5a WHERE day='MONDAY' AND hour='2'";

                    // statement2 = connection.createStatement();
                    rs1 = statement2.executeQuery(sql3);
                    if (rs1.next() == false) { break blabel;
                    } else {
                        name1 = rs1.getString("subject");
                        str1 = rs1.getString("faculty");
                        m2.setText(name1 + "\n" + str1);

                        System.out.println("111");
                    }
                }


                blabel2:
                {
                    sql3 = "SELECT * FROM timetable5a WHERE day='MONDAY' AND hour='3'";

                    // statement2 = connection.createStatement();
                    rs1 = statement2.executeQuery(sql3);
                    if (rs1.next() == false) { break blabel2;
                    } else {
                        name1 = rs1.getString("subject");
                        str1 = rs1.getString("faculty");
                        m3.setText(name1 + "\n" + str1);

                        System.out.println("111");
                    }
                }




                sql3 = "SELECT * FROM timetable5a WHERE day='MONDAY' AND hour='4'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                m4.setText(name1 + "\n" + str1);
                System.out.println("1111");


                sql3 = "SELECT * FROM timetable5a WHERE day='MONDAY' AND hour='5'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");

                if (m.find()) {
                    System.out.println("matched");
                    m5.setText(name1 + "\n" + str1);
                    m6.setText(name1 + "\n" + str1);
                    m7.setText(name1 + "\n" + str1);

                } else {
                    m5.setText(name1 + "\n" + str1);
                }
                System.out.println("11111");

                sql3 = "SELECT * FROM timetable5a WHERE day='MONDAY' AND hour='6'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                m6.setText(name1 + "\n" + str1);
                System.out.println("111111");

                sql3 = "SELECT * FROM timetable5a WHERE day='MONDAY' AND hour='7'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                m7.setText(name1 + "\n" + str1);
                System.out.println("1111111");

                sql3 = "SELECT * FROM timetable5a WHERE day='TUESDAY' AND hour='1'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    t1.setText(name1 + "\n" + str1);
                    t2.setText(name1 + "\n" + str1);
                    t3.setText(name1 + "\n" + str1);

                } else {
                    t1.setText(name1 + "\n" + str1);
                }
                System.out.println("11111111");

                sql3 = "SELECT * FROM timetable5a WHERE day='TUESDAY' AND hour='2'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                t2.setText(name1 + "\n" + str1);
                System.out.println("111111111");
                sql3 = "SELECT * FROM timetable5a WHERE day='TUESDAY' AND hour='3'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                t3.setText(name1 + "\n" + str1);
                System.out.println("111111111");

                sql3 = "SELECT * FROM timetable5a WHERE day='TUESDAY' AND hour='4'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                t4.setText(name1 + "\n" + str1);
                System.out.println("111111111");

                sql3 = "SELECT * FROM timetable5a WHERE day='TUESDAY' AND hour='5'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    t5.setText(name1 + "\n" + str1);
                    t6.setText(name1 + "\n" + str1);
                    t7.setText(name1 + "\n" + str1);

                } else {
                    t5.setText(name1 + "\n" + str1);
                }
                System.out.println("111111111");

                sql3 = "SELECT * FROM timetable5a WHERE day='TUESDAY' AND hour='6'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                t6.setText(name1 + "\n" + str1);
                System.out.println("111111111");

                sql3 = "SELECT * FROM timetable5a WHERE day='TUESDAY' AND hour='7'";

                    ///statement2 = connection.createStatement();
                    rs1 = statement2.executeQuery(sql3);
                    rs1.next();
                    name1 = rs1.getString("subject");
                    str1 = rs1.getString("faculty");
                    t7.setText(name1 + "\n" + str1);
                    System.out.println("111111111");


                sql3 = "SELECT * FROM timetable5a WHERE day='WEDNESDAY' AND hour='1'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    w1.setText(name1 + "\n" + str1);
                    w2.setText(name1 + "\n" + str1);
                    w3.setText(name1 + "\n" + str1);

                } else {
                    w1.setText(name1 + "\n" + str1);
                }
                System.out.println("1111111111");



                sql3 = "SELECT * FROM timetable5a WHERE day='WEDNESDAY' AND hour='2'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                w2.setText(name1 + "\n" + str1);
                System.out.println("11111111111");

                blabel1:
                {
                    sql3 = "SELECT * FROM timetable5a WHERE day='WEDNESDAY' AND hour='3'";

                    // statement2 = connection.createStatement();
                    rs1 = statement2.executeQuery(sql3);
                    if (rs1.next() == false) { break blabel1;
                    } else {
                        name1 = rs1.getString("subject");
                        str1 = rs1.getString("faculty");
                        w3.setText(name1 + "\n" + str1);

                        System.out.println("111");
                    }
                }

                sql3 = "SELECT * FROM timetable5a WHERE day='WEDNESDAY' AND hour='4'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                w4.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='WEDNESDAY' AND hour='5'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    w5.setText(name1 + "\n" + str1);
                    w6.setText(name1 + "\n" + str1);
                    w7.setText(name1 + "\n" + str1);

                } else {
                    w5.setText(name1 + "\n" + str1);
                }

                sql3 = "SELECT * FROM timetable5a WHERE day='WEDNESDAY' AND hour='6'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                w6.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='WEDNESDAY' AND hour='7'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                w7.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='THURSDAY' AND hour='1'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    th1.setText(name1 + "\n" + str1);
                    th2.setText(name1 + "\n" + str1);
                    th3.setText(name1 + "\n" + str1);

                } else {
                    th1.setText(name1 + "\n" + str1);
                }

                sql3 = "SELECT * FROM timetable5a WHERE day='THURSDAY' AND hour='2'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                th2.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='THURSDAY' AND hour='3'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                th3.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='THURSDAY' AND hour='4'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                th4.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='THURSDAY' AND hour='5'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    th5.setText(name1 + "\n" + str1);
                    th6.setText(name1 + "\n" + str1);
                    th7.setText(name1 + "\n" + str1);

                } else {
                    th5.setText(name1 + "\n" + str1);
                }

                sql3 = "SELECT * FROM timetable5a WHERE day='THURSDAY' AND hour='6'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                th6.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='THURSDAY' AND hour='7'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                th7.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='FRIDAY' AND hour='1'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    f1.setText(name1 + "\n" + str1);
                    f2.setText(name1 + "\n" + str1);
                    f3.setText(name1 + "\n" + str1);

                } else {
                    f1.setText(name1 + "\n" + str1);
                }

                sql3 = "SELECT * FROM timetable5a WHERE day='FRIDAY' AND hour='2'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                f2.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='FRIDAY' AND hour='3'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                f3.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='FRIDAY' AND hour='4'";

                //statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                f4.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='FRIDAY' AND hour='5'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                if (m.find()) {
                    System.out.println("matched");
                    f5.setText(name1 + "\n" + str1);
                    f6.setText(name1 + "\n" + str1);
                    f7.setText(name1 + "\n" + str1);

                } else {
                    f5.setText(name1 + "\n" + str1);
                }

                sql3 = "SELECT * FROM timetable5a WHERE day='FRIDAY' AND hour='6'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                f6.setText(name1 + "\n" + str1);

                sql3 = "SELECT * FROM timetable5a WHERE day='FRIDAY' AND hour='7'";

                // statement2 = connection.createStatement();
                rs1 = statement2.executeQuery(sql3);
                rs1.next();
                name1 = rs1.getString("subject");
                str1 = rs1.getString("faculty");
                f7.setText(name1 + "\n" + str1);
                System.out.println("Hellos");
            } catch (SQLException e) {
                e.printStackTrace();
            }



    }


    public void update(ActionEvent actionEvent) {
        String sql0="SELECT  `subject` FROM `timetable5a` WHERE day='"+comboBox12.getValue()+"' AND hour='"+comboBox121.getValue()+"';";
        String sql1="DELETE FROM `timetable5a` WHERE day='"+comboBox12.getValue()+"' AND hour='"+comboBox121.getValue()+"';";
        String sqlab1="DELETE FROM `timetable5a` WHERE day='"+comboBox12.getValue()+"' AND hour='"+comboBox121.getValue()+1+"';";
        String sqlab2="DELETE FROM `timetable5a` WHERE day='"+comboBox12.getValue()+"' AND hour='"+comboBox121.getValue()+2+"';";

        String sql3="INSERT INTO `timetable5a` (`day`, `hour`, `subject`, `faculty`, `section`) VALUES('"+comboBox12.getValue()+"', '"+comboBox121.getValue()+"', '"+comboBox1.getValue()+"', '"+label.getText()+"', 'A');";
        String sqlabupdate="INSERT INTO `timetable5a` (`day`, `hour`, `subject`, `faculty`, `section`) VALUES('"+comboBox12.getValue()+"', '"+comboBox121.getValue()+1+"', '"+comboBox1.getValue()+"', '"+label.getText()+"', 'A');";
        String sqlabupdate1="INSERT INTO `timetable5a` (`day`, `hour`, `subject`, `faculty`, `section`) VALUES('"+comboBox12.getValue()+"', '"+comboBox121.getValue()+2+"', '"+comboBox1.getValue()+"', '"+label.getText()+"', 'A');";

        subjcount= (String) comboBox1.getValue();
        String sql4="UPDATE `count` SET `countof`=countof-1 WHERE subject='"+subjcount+"' AND section='A'";

        try {


            rs=statement.executeQuery(sql0);
            rs.next();
            String subjectUpdate=rs.getString("subject");
            String sql2="UPDATE `count` SET `countof`=countof+1 WHERE subject='"+subjectUpdate+"'AND section='A';";
            Pattern p=Pattern.compile("LAB");
            Matcher m=p.matcher(subjectUpdate);
            if(m.find())
            {String sqlabcount="UPDATE `count` SET `countof`=countof+4 WHERE subject='"+subjectUpdate+"'AND section='A';";
                statement.execute(sql1);
             statement.execute(sqlab1);
             statement.execute(sqlab2);
                statement.executeUpdate(sqlabcount);




            }
            else {

                statement.execute(sql1);
                statement.executeUpdate(sql2);
                Pattern p1=Pattern.compile("LAB");
                Matcher m1=p1.matcher(subjectUpdate);
                if(m1.find()){
                    statement.executeUpdate(sql3);
                    statement.executeUpdate(sqlabupdate);
                    statement.executeUpdate(sqlabupdate1);





                }
                else {
                    statement.executeUpdate(sql3);
                    statement.executeUpdate(sql4);
                }

            }

            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void clearall(ActionEvent actionEvent) {

        String sql="DELETE FROM `timetable5a`";
        String sql1="UPDATE `count` SET `countof`=4 WHERE section='A';";
        try {statement = connection.createStatement();
            statement1 = connection.createStatement();
            statement1.executeUpdate(sql1);
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        refresh();
    }
}



