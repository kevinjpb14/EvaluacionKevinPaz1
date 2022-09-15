package com.example.EvaluacionKevinPaz;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/consumo")
//@CrossOrigin(origins = "http://localhost")
@SpringBootApplication


public class EvaluacionKevinPazApplication {
  
   

    @Autowired
    private consumo_repositorio Consumo_Repositorio;
    

    private HttpClient httpclient = HttpClient.newBuilder().version(Version.HTTP_2).build();
    private final Object[] columnas = new Object[]{"ID","Id Usuario","Post","Comentario"};
    private final DefaultTableModel model = new DefaultTableModel(columnas,0);       
 
    public EvaluacionKevinPazApplication (){
        
        final HttpRequest requestPosts = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("https://api.chucknorris.io/jokes/categories"))
        .build();

        try {
            final HttpResponse<String> response = httpclient.send(requestPosts, HttpResponse.BodyHandlers.ofString());
            List<consumo> lista = new ArrayList<consumo>();
            String response1 = response.body().replaceAll("[{\\[\\]}]", "");
            System.out.println(response.body());
            System.out.println(response1);
            String split[] = response1.split(",");
            for (int x = 0; x < split.length; x++) {
                String splitFila[] = split[x].split(",");
                System.out.println(split[x]);
                
                    //  consumo a = new consumo(split[x]);
                    //   Consumo_Repositorio.save(a);
                               
              }
              System.out.println("PRESENTACION DE CONTENIDO DE LISTA");
                
                for (int i=0;i<lista.size();i++) {
      
                    System.out.println(lista.get(i));
                  }

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
    /* @RequestMapping(value = "/crear1", method = RequestMethod.GET)
    public String test () {
        consumo a = new consumo("Kevin Paz");
        Consumo_Repositorio.save(a);
        return "Guardado";
        //return Consumo_Repositorio.save(Consumo);

    } */


   @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public consumo crearConsumo(@RequestBody consumo Consumo) {
        
        return Consumo_Repositorio.save(Consumo);
        
    }
 
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    public Iterable<consumo> obtenerTodos() {
        return Consumo_Repositorio.findAll();
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable() Long id) {
        Consumo_Repositorio.deleteById(id);
        return true;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public consumo editar(@RequestBody consumo Consumo) {
        return Consumo_Repositorio.save(Consumo);
    }
 

	public static boolean esMultiplo(int n1,int n2){
        if (n1%n2==0)
            return true;
        else
            return false;


    }
	public static void main(String[] args) {
		SpringApplication.run(EvaluacionKevinPazApplication.class, args);
        
     
        
//----------------------------------------------------------------------------------------------
	    // Listar los multiplos de un número
// Multiplos de 3 y 5
int multiplo3 = 3;
int multiplo5 = 5;
System.out.println("------------NUMEROS DEL 1 AL 100------------");
for (int x=1;x<100;x++){
	
	if (esMultiplo(x,multiplo3) && esMultiplo(x, multiplo5) ){
		System.out.println("SOMOS BA");
	}
	else
	if (esMultiplo(x,multiplo3)){
		System.out.println("SOMOS");
	}
	else
	if (esMultiplo(x,multiplo5)){
		System.out.println("BA");
	}
	else
	{System.out.println(x);}
	
}

//----------------------------------------------------------------------------------------------

System.out.println("------------Compara 2 String y verifica si es un Anagrama------------");
String palabra1 = "hila";        
String palabra2 = "AlOh";
Scanner teclado=new Scanner(System.in);
System.out.println("Ingrese la primera palabra:");
        palabra1=teclado.next();
System.out.println("Ingrese la segunda palabra:");
        palabra2=teclado.next();
    

if (isAnagram(palabra1.toLowerCase(), palabra2.toLowerCase())) {
	System.out.println("Si es un Anagrama");
}
else {
	System.out.println("No es un Anagrama");


	}
	try {
		Thread.sleep(3*1000);
	 } catch (Exception e) {
		System.out.println(e);
	 }
//----------------------------------------------------------------------------------------------
System.out.println("------------Ordenamiento de Arreglo------------");
System.out.println("Arreglo desordenado: 50,5,10,36,25,85,23,65");
int arreglo[]={50,5,10,36,25,85,23,65};
Arrays.sort(arreglo);
try {
    Thread.sleep(2*1000);
 } catch (Exception e) {
    System.out.println(e);
 }
System.out.println("Arreglo ordenado de mayor a menor: ");
try {
    Thread.sleep(2*1000);
 } catch (Exception e) {
    System.out.println(e);
 }
for (int i = arreglo.length-1;i >=0; i--)
	{
		System.out.println(arreglo[i]);
	}
}


public static boolean isAnagram(String X, String Y)
    {
        // caso base
        if (X == null || Y == null) {
            return false;
        }
 
        // si la longitud de la 1era no es la misma que la de la 2da, no pueden ser un anagrama
        if (X.length() != Y.length()) {
            return false;
        }
 
        // crea un mapa vacio
        Map<Character, Integer> freq = new HashMap<>();
 
        for (char c: X.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
 
      
        for (char c: Y.toCharArray())
        {
       
            if (!freq.containsKey(c)) {
                return false;
            }
 
            freq.put(c, freq.get(c) - 1);
 
            // si su frecuencia se vuelve 0, lo borra del mapa
            if (freq.get(c) == 0) {
                freq.remove(c);
            }
        }
 
        // devuelve verdadero si el mapa se vacía
        return freq.isEmpty();

    }
 
	

       }