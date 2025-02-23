//package Grandao.Controladores;
//
//import Grandao.DTO.EjemplarDTO;
//import Grandao.Service.EjemplarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/ejemplares")
//public class EjemplarController {
//
//    @Autowired
//    private EjemplarService ejemplarService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EjemplarDTO> getEjemplar(@PathVariable Long id) {
//        EjemplarDTO ejemplar = ejemplarService.getEjemplar(id);
//        return ResponseEntity.ok(ejemplar);
//    }
//
//    @PostMapping
//    public ResponseEntity<EjemplarDTO> createEjemplar(@RequestBody EjemplarDTO ejemplarDTO) {
//        EjemplarDTO created = ejemplarService.createEjemplar(ejemplarDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(created);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<EjemplarDTO> updateEjemplar(@PathVariable Long id, @RequestBody EjemplarDTO ejemplarDTO) {
//        EjemplarDTO updated = ejemplarService.updateEjemplar(id, ejemplarDTO);
//        return ResponseEntity.ok(updated);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEjemplar(@PathVariable Long id) {
//        ejemplarService.deleteEjemplar(id);
//        return ResponseEntity.noContent().build();
//    }
//}
