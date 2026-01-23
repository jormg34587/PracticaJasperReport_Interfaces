/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd_interfaces.conectoresbbdd;

public class Department {
    
    private int id;
    private String name;
    private int idDirector;
    private int idLocalizacion;

    public Department(int id, String name, int idDirector, int idLocalizacion) {
        this.id = id;
        this.name = name;
        this.idDirector = idDirector;
        this.idLocalizacion = idLocalizacion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }
    
    
    
}
