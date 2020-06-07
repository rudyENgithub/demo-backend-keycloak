package frm.utn.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/ecom")

public class ProductoController {


@PreAuthorize("authenticated")  //Seguridad para todos los recursos, en este caso deben estar todos autenticados.

 @GetMapping("/saludar")
 public String saludar() throws Exception {

    return "Hola, chau";


}

@PreAuthorize("hasAnyRole('ROLE_admin', 'ROLE_cocinero')")
@GetMapping("/products")
    public String getProducts() throws Exception {

       return  "Pizza, Empanada, Lomo";


}
@PreAuthorize("hasAnyRole('ROLE_admin')")
@GetMapping("/products/stock")
    public String getStock() throws Exception {

       return  "Este es el Stock";


}



}
