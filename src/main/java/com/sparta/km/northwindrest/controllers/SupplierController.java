package com.sparta.km.northwindrest.controllers;

import com.sparta.km.northwindrest.controllers.supplier.SupplierWithCity;
import com.sparta.km.northwindrest.controllers.supplier.SupplierWithContactTitle;
import com.sparta.km.northwindrest.controllers.supplier.SupplierWithCountry;
import com.sparta.km.northwindrest.dto.SupplierDTO;
import com.sparta.km.northwindrest.entities.ProductEntity;
import com.sparta.km.northwindrest.entities.SupplierEntity;
import com.sparta.km.northwindrest.repositories.SupplierRepository;
import com.sparta.km.northwindrest.services.SupplierService;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierRepository supplierRepository;
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
        supplierService = new SupplierService();
        supplierService.setRepo(supplierRepository);
    }

    @GetMapping
    public List<SupplierDTO> findSuppliers(@RequestParam(value = "contactTitle", required = false) String contactTitle,
                                           @RequestParam(value = "city", required = false) String city,
                                           @RequestParam(value = "country", required = false) String country) {
        Specification<SupplierEntity> spec = Specification.where(new SupplierWithContactTitle(contactTitle))
                .and(new SupplierWithCity(city))
                .and(new SupplierWithCountry(country));

        //return supplierRepository.findAll(spec);
        return supplierService.getCustomSuppliers(spec);
    }

    @GetMapping("/{id}")
    public Optional<SupplierEntity> getProductById(@PathVariable Integer id) {
        return supplierRepository.findById(id);
    }

//    @GetMapping("/suppliers")
//    @ResponseBody
//    public List<SupplierEntity> getAllSuppliers(@RequestParam(required = false) String name,
//                                                @RequestParam(required = false) String title,
//                                                @RequestParam(required = false) String city,
//                                                @RequestParam(required = false) String region) {
//        if (name == null && title == null && city == null && region == null) {
//            return supplierRepository.findAll();
//        }
//
////        Specification<SupplierEntity> spec = Specifications.where()
//        return supplierRepository.findAll();
//    }
//
//    @GetMapping("/suppliers")
//    public List<SupplierEntity> getAllSuppliers(SupplierSpec supplierSpec) {
//        return supplierRepository.findAll(supplierSpec);
//    }

//    @GetMapping
//    public List<SupplierEntity> getAllSuppliers() {
//        return supplierRepository.findAll();
//    }



    //works but need to provide all three params to return data.
//    @GetMapping(value = "/suppliers", params = {"contactTitle","city","region"})
//    public List<SupplierEntity> getSuppliersSearch(@RequestParam(required = false) String contactTitle,
//                                                @RequestParam(required = false) String city,
//                                                @RequestParam(required = false) String region) {
//
//        return supplierRepository.findAll()
//                .stream()
//                .filter(supplierEntity ->
//                        (supplierEntity.getContactTitle().contains(contactTitle) &&
//                                (supplierEntity.getCity().contains(city) &&
//                                        (supplierEntity.getRegion().contains(region)))))
//                .collect(Collectors.toList());
//    }

}
