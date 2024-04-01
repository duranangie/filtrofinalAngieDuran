// package com.movie.main.controllers;

// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.movie.main.models.dtos.ContenidoDTO;
// import com.movie.main.models.dtos.ContenidoPostDTO;
// import com.movie.main.services.ContenidoService;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

// @RestController
// @RequestMapping("/facturas")
// @CrossOrigin("*")
// @PreAuthorize("hasRole('ADMIN')")
// @SecurityRequirement(name = "bearerAuth")
// public class ContenidoController {
//       @Autowired
//     ContenidoService contenidoService;

//      @GetMapping
//     public List<ContenidoDTO> getAllContenido() {
//         return contenidoService.getAllContenido();
//     }

    
//     @GetMapping("/{id}")
//     public ContenidoDTO getContenidoById(@PathVariable Object id) {
//         return contenidoService.getContenidoById(id);
//     }

//     @PostMapping
//     public Map<Object, Object> saveContenido(@RequestBody ContenidoPostDTO contenidoPostDTO) {
//         return contenidoService.saveContenido(contenidoPostDTO);
//     }

//      @PutMapping("/{id}")
//     public Map<Object, Object> updateContenido(@PathVariable Object id, @RequestBody ContenidoPostDTO contenidoPostDTO) {
//         return contenidoService.updateContenido(id, contenidoPostDTO);
//     }

    
//     @DeleteMapping("/{id}")
//     public Map<Object, Object> deleteContenido(@PathVariable Object id) {
//         return contenidoService.deleteContenido(id);
//     }
// }
