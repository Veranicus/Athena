/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gru100
 */

//Vytvořili jsme úvodní stránku tak, aby bylo možné vložit trojici údajů za předpokladu, že uživatel
//napsal správné heslo. My chceme ze všech zadaných údajů odělat jeden záznam, se kterým pak dále budeme
//pracovat. Záznam pak bude reprezentován objektem této třídy.
public class Athena {
 
//Uživatel zadá své jméno, status a místo. Pro každý z těchto parametrů proto vytvoříme základní deklaraci
//a konstruktor. Funkci programu pak budeme implementovat v servletu.
    
    private String name;
    private String place;
    private String status;

    public Athena(String name, String place, String status) {
        this.name = name;
        this.place = place;
        this.status = status;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
