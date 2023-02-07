package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.application.OrderApplication;
import br.com.fiap.abctechservice.application.dto.OrderDto;
import br.com.fiap.abctechservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderApplication orderApplication;


    public OrderController(@Autowired OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    @PostMapping()
    public ResponseEntity createOrder(
            @Valid
            @RequestBody
            OrderDto orderDto
    ){
        orderApplication.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/operator/{operatorId}")
    public ResponseEntity<List<Order>> getOrderByOperator(@PathVariable("operatorId") Long operatorId){
        return ResponseEntity.ok(orderApplication.getOrdersByOperator(operatorId));
    }

}
