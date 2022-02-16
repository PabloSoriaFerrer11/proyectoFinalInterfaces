/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class conexion {

    public static Connection conexion = null;

    public static Connection conectar(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/personajesrol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        return conexion;
    }    
        
    public ArrayList<Personaje> seleccionarTodosPersonajes() {
        ArrayList<Personaje> l = new ArrayList<Personaje>();
         try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                PreparedStatement stmt = cn.prepareStatement("SELECT * FROM personajes");
                ResultSet rs = stmt.executeQuery();
                
                int contAux = 0;
                while(rs.next()){
                    int id = rs.getInt(1);
                    String n = rs.getString(2);
                    String cl = rs.getString(3);
                    int pv = rs.getInt(4);
                    int pm = rs.getInt(5);
                    int ar = rs.getInt(6);
                    int da = rs.getInt(7);
                    int d = rs.getInt(8);
                    
                    Personaje p = new Personaje(id, n, cl, pv, pm, ar, da, d);
                    l.add(p);
                }
                rs.close();
                cn.close();
                return l;
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return null;
    }

    public boolean insertarPersonaje(Personaje p) {
          try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                
                PreparedStatement stmt = cn.prepareStatement("INSERT INTO `personajes` (`id`, `nombre`, `clase`, `puntosvida`, `puntosmana`, `puntosarmadura`, `puntosdaño`, `dinerototal`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);");
                stmt.setString(1, p.getNombre());
                stmt.setString(2, p.getClase());
                stmt.setInt(3, p.getPuntosvida());
                stmt.setInt(4, p.getPuntosmana());
                stmt.setInt(5, p.getPuntosarmadura());
                stmt.setInt(6, p.getPuntosdanyo());
                stmt.setInt(7, p.getDinero());
                
                int aux = stmt.executeUpdate();
                
                cn.close();
                if(aux==1)
                    return true;
                else
                    return false;
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return false;
    }

    public boolean eliminarPersonaje(int id) {
          try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                
                PreparedStatement stmt = cn.prepareStatement("DELETE FROM `personajes` WHERE id=(?)");
                stmt.setInt(1, id);
                
                int aux = stmt.executeUpdate();
                
                cn.close();
                if(aux==1)
                    return true;
                else
                    return false;
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return false;
    }
    
    public boolean insertarObjeto(Objetos obj) {
          try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                
                PreparedStatement stmt = cn.prepareStatement("INSERT INTO `tablaobjetos` (`id`, `nombre`, `precio`, `descripcion`, `daño`, `armadura`, `tipoobjeto`) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
                stmt.setString(1, obj.getNombre());
                stmt.setInt(2, obj.getPrecio());
                stmt.setString(3, obj.getDescripcion());
                stmt.setInt(4, obj.getDaño());
                stmt.setInt(5, obj.getArmadura());
                stmt.setString(6, obj.getTipo());
                
                int aux = stmt.executeUpdate();
                
                cn.close();
                if(aux==1)
                    return true;
                else
                    return false;
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return false;
    }

    public String[] actualizarComboObj() {
        
        try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                
                PreparedStatement stmt = cn.prepareStatement("SELECT COUNT(*) FROM tablaobjetos");
                
                ResultSet rs = stmt.executeQuery();
                
                int numObj = 0;
                while(rs.next()){
                    numObj = rs.getInt(1);
                }
                
                rs.close();
                
                String[] array = new String[numObj];
                
                PreparedStatement stmt2 = cn.prepareStatement("SELECT nombre FROM tablaobjetos");
                
                ResultSet rs2 = stmt2.executeQuery();
                
                int cont = 0;
                String nObj;
                while(rs2.next()){
                    
                    array[cont] = rs2.getString(1);
                    cont++;
                    
                }
                
                rs2.close();
                
                cn.close();
                if(array.length==0)
                    return null;
                else
                    return array;
                
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return null;
    }

    public boolean agregarObjeto(String obj, int id) {
        try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                
                PreparedStatement stmt = cn.prepareStatement("SELECT id FROM `tablaobjetos` WHERE `nombre` = (?) ");
                stmt.setString(1, obj);
                
                ResultSet rs = stmt.executeQuery();
                
                int idobj =0;
                while(rs.next()){
                    idobj = rs.getInt(1);
                }
                rs.close();
                
                PreparedStatement stmt2 = cn.prepareStatement("INSERT INTO `objetospersonajes` (`idpersonaje`,`idobjeto`) VALUES (?, ?);");
                stmt2.setInt(1, id);
                stmt2.setInt(2, idobj);
                
                int aux = stmt2.executeUpdate();
                
                cn.close();
                if(aux==1)
                    return true;
                else
                    return false;
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return false;
    }

    public boolean agregarObjetoRandom(int id) {
        try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                //SELECT * FROM tablaobjetos ORDER BY RAND() LIMIT 1;
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM tablaobjetos ORDER BY RAND() LIMIT 1;");
                
                ResultSet rs = ps.executeQuery();
                
                String nombre = " ";
                int idObj = 0;
                while(rs.next()){
                    idObj = rs.getInt(1);
                    nombre = rs.getString(2);
                }
                rs.close();

                //Ahora añadimos el objeto a la tabla
                
                PreparedStatement stmt2 = cn.prepareStatement("INSERT INTO `objetospersonajes` (`idpersonaje`,`idobjeto`) VALUES (?, ?);");
                stmt2.setInt(1, id);
                stmt2.setInt(2, idObj);
                
                int aux = stmt2.executeUpdate();
                
                cn.close();
                if(aux==1){
                    JOptionPane.showMessageDialog(null, "Te ha tocado " + nombre);
                    return true;
                }else
                    return false;
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return false;
    }

    public ArrayList<Objetos> seleccionarObjetosPersonaje(int id) {
        ArrayList<Objetos> lista = new ArrayList<>();
        try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                PreparedStatement stmt = cn.prepareStatement("SELECT * FROM objetospersonajes WHERE idpersonaje = (?)");
                stmt.setInt(1, id);
                
                ResultSet rs = stmt.executeQuery();
                int idObj = 0;
                while(rs.next()){
                    idObj = rs.getInt(2);
                
                    PreparedStatement stmt2 = cn.prepareStatement("SELECT * FROM tablaobjetos WHERE id = (?)");
                    stmt2.setInt(1, idObj);
                    
                    System.out.println("");
                    
                    System.out.println("");
                    
                    ResultSet rs2 = stmt2.executeQuery();
                    while(rs2.next()){
                        int idO = rs2.getInt(1);
                        String n = rs2.getString(2);
                        int p = rs2.getInt(3);
                        String d = rs2.getString(4);
                        int dmg = rs2.getInt(5);
                        int ar = rs2.getInt(6);
                        String tipo = rs2.getString(7);
                        
                        Objetos a = new Objetos(idO, n, p, d, dmg, ar, tipo);
                        lista.add(a);
                        
                    }
                    rs2.close();
                }
                
                cn.close();
                
                return lista;
          
            }   
         }catch(SQLException e){
             e.printStackTrace(System.err);
        
        }
        return null;
    }

    public boolean updatePersonaje(Personaje per) {
        try{
            Connection cn = conectar();	
            
            if(cn==null){
                System.out.println("Fallo en la conexion");
            }else{
                //UPDATE tablaobjetos SET daño = 7, precio = 30 WHERE id = 5;
                PreparedStatement stmt = cn.prepareStatement("UPDATE personajes SET puntosvida = (?), puntosmana = (?), puntosarmadura = (?), puntosdaño = (?), dinerototal = (?) WHERE id = (?)");
                stmt.setInt(1, per.getPuntosvida());
                stmt.setInt(2, per.getPuntosmana());
                stmt.setInt(3, per.getPuntosarmadura());
                stmt.setInt(4, per.getPuntosdanyo());
                stmt.setInt(5, per.getDinero());
                stmt.setInt(6, per.getId());
                
                int aux = stmt.executeUpdate();
                
                if(aux==1)
                    return true;
                else
                    return false;
            }  
         }catch(SQLException e){
             e.printStackTrace(System.err);
        }
        return false;
    }
    
}
