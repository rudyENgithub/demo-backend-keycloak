package frm.utn.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/ecom")
public class ProductoController {


    @GetMapping("/mensajes")
    @Transactional
    public ResponseEntity<?> getMensajes()throws Exception {
       List<String> mensajes= new ArrayList();       
       mensajes.add("Bienvenido al mejor sitios de pedidos");
       mensajes.add("Nos alegra tu visita");   
       mensajes.add("Logueate o registrate para comenzar a hacer tus ordenes");   
     try{
       return ResponseEntity.status(HttpStatus.OK).body(mensajes);
   
     }catch(Exception e){
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
       .body("{\"Mi mensaje \": \"" + e.getMessage() + "\"}");
     }
     }

    @PreAuthorize("authenticated")  
        //Test Params
        @GetMapping("/saludo")
        @Transactional
        public ResponseEntity<?> testParam(@RequestParam("valor")String valor)throws Exception {
            List<String> bienvenida= new ArrayList();       
            bienvenida.add("Hola");
            bienvenida.add("Que tal");      

            List<String> despedida= new ArrayList();       
            despedida.add("Chau");
            despedida.add("Adios");   
            
            
         try{
             if(valor.equals("1")){
           return ResponseEntity.status(HttpStatus.OK).body(bienvenida);
             }else{
          return ResponseEntity.status(HttpStatus.OK).body(despedida);

             }
         }catch(Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
           .body("{\"Mi mensaje \": \"" + e.getMessage() + "\"}");
         }
         }


     //solo autenticados
     @PreAuthorize("authenticated")  
     //@PreAuthorize("hasAnyRole('ROLE_admin', 'ROLE_cocinero')")
     @GetMapping("/productos")
     @Transactional
     public ResponseEntity<?> getProducts()throws Exception {
        List<String> productos= new ArrayList();       
        productos.add("Empanadas");
        productos.add("Lomos");   
        productos.add("Pizzas");   
      try{
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    
      }catch(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("{\"Mi mensaje \": \"" + e.getMessage() + "\"}");
      }
      }


//solo autorizados, en este caso esta autorizado el admin
      @PreAuthorize("hasAnyRole('ROLE_admin')")
      @GetMapping("/productos/stock")
      @Transactional
      public ResponseEntity<?> getStock()throws Exception {
        List<String> stock= new ArrayList();       
        stock.add("100 hamburguesas");
        stock.add("20 lomos");   
        stock.add("300 pizzas");
       try{
         return ResponseEntity.status(HttpStatus.OK).body(stock);
     
       }catch(Exception e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND)
         .body("{\"Mi mensaje \": \"" + e.getMessage() + "\"}");
       }
       }


/*
    //publico
    @GetMapping("/saludo")
    @Transactional
    public ResponseEntity<?> getSaludo()throws Exception {
        List<String> saludo= new ArrayList();       
        saludo.add("Hola");
        saludo.add("Chau");      
     try{
       return ResponseEntity.status(HttpStatus.OK).body(saludo);
   
     }catch(Exception e){
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
       .body("{\"Mi mensaje \": \"" + e.getMessage() + "\"}");
     }
     }
*/
}
