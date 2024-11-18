/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinevoting;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JEYAPRAGASH
 */
public class sqlcon {
    private Connection con;
    private Statement st;
    private ResultSet rs;
 //<----SQLCONNECTIONS   
    sqlcon(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem","root","root");
            st=con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//---->
    
    //<-----SEARCH_VOTE

    /**
     *
     * @param search
     * @return
     */
    public ResultSet search(String search){
 
   String sql="select * from personal_info where NIC='"+search+"'";
   try{
   rs=st.executeQuery(sql);
   }catch(Exception e){
   System.out.println(e);
   }
   return rs;   
     
 }//------->
    
    //<-----LOGIN_VOTE

    /**
     *
     * @param nic
     * @param year
     * @return
     */
    public ResultSet login_vote(int nic, int year){
        
        try {
            String query="select * from personal_info where NIC='"+nic+"' and Birth_Year='"+year+"' and Vote='yes' ";
            rs=st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }//------>
    
    
    //<-----VOTE_DETAILS

    /**
     *
     * @param id
     * @return
     */
    public ResultSet get_per(int id){
        
        try {
            String q="select * from personal_info where NIC="+id;
            rs=st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }//------>
    
    
    //<------VOTE

    /**
     *
     * @param field1
     * @param name
     * @param fname
     * @param year
     * @param city
     * @param group
     */
    public void vote(int field1, String name, String fname, int year, String city, String group){
    
        try {
            String q ="insert into voting(NIC, Name, F_Name, DBO, City, Done) VALUES "
                    + "('"+field1+"','"+name+"','"+fname+"','"+year+"','"+city+"','"+group+"','done')";
            st.executeUpdate(q);
        }
        catch (Exception e) {
            System.out.println(e);
        }        
    } //------>
    
    
    //<-----ADMIN_LOGIN

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public ResultSet admin_login(String username, String password){
        
        try {
            String query="select * from admin_login where Username='"+username+"' and Password='"+password+"'";
            rs=st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }//------>
    
    
    //<------ADD_PEOPLE

    /**
     *
     * @param name
     * @param fname
     * @param nic
     * @param gender1
     * @param year
     * @param address
     * @param city
     * @param allow1
     */
    public void add_people(String name, String fname, int nic, String gender1, int year, String address, String city, String allow1){
    
        try {
            String q ="insert into personal_info(Name, F_Name, NIC, Gender, Birth_Year, Address, City, Vote) VALUES "
                    + "('"+name+"','"+fname+"',"+nic+",'"+gender1+"',"+year+",'"+address+"','"+city+"','"+allow1+"')";
            st.executeLargeUpdate(q);
        }
        catch (Exception e) {
            System.out.println(e);
        }        
    } //------>
    
    
    //<------UPDATE_PEOPLE

    /**
     *
     * @param id
     * @param name
     * @param fname
     * @param nic
     * @param gender1
     * @param year
     * @param address
     * @param city
     * @param vote1
     */
    public void update_people(int id, String name, String fname,int nic, String gender1, int year, String address, String city, String vote1){
    
        String uq="update personal_info set Name='"+name+"', F_Name='"+fname+"',NIC='"+nic+"',Gender='"+gender1+"',Birth_Year='"+year+"'"
                + ",Address='"+address+"',City='"+city+"',Vote='"+vote1+"' where Id='"+id+"' ";
        
        try {
            st.executeUpdate(uq);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public ResultSet fetch_people(){
    
        String fq="select * from personal_info";
        
        try {
            rs=st.executeQuery(fq);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void delete_people(int id){
    
        try {
            String del="delete from personal_info where Id='"+id+"' ";
            st.executeUpdate(del);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet search1(String search1){
 
   String sql="select * from personal_info where NIC like '"+search1+"'";
   try{
   rs=st.executeQuery(sql);
   }catch(Exception e){
   System.out.println(e);
   }
   return rs;   
     
 }
    public ResultSet count(){
 
   try {
            String q="SELECT COUNT(*) FROM voting";
            rs=st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;  
     
 }
    public ResultSet winner(){
 
   try {
            String q="SELECT MAX FROM voting";
            rs=st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;  
     
 }
    public ResultSet C1(){
 
   try {
            String q="SELECT COUNT FROM voting WHERE  = \"likirthan\"";
            rs=st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;  
     
 }
    public ResultSet C2(){
 
   try {
            String q="SELECT COUNT FROM voting WHERE  = \"sivani\"";
            rs=st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;  
     
 }
    public ResultSet C3(){
 
   try {
            String q="SELECT COUNT FROM voting WHERE  = \"S.D.M.NILANKA\"";
            rs=st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;  
     
 }
    public ResultSet C4(){
 
   try {
            String q="SELECT COUNT FROM voting WHERE  = \"M.N.D..HARICHANTHIRA\"";
            rs=st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;  
     
 }
   
 
}
