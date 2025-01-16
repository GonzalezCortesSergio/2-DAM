package com.salesianostriana.dam.composicion;

import com.salesianostriana.dam.composicion.model.LineaPedido;
import com.salesianostriana.dam.composicion.model.Pedido;
import com.salesianostriana.dam.composicion.repo.PedidoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final PedidoRepository pedidoRepository;

    @PostConstruct
    public void init() {

        Pedido p1 = Pedido.builder()
                .cliente("Luismi")
                .build();
        LineaPedido lp1 = LineaPedido.builder()
                .cantidad(2)
                .precioVenta(2.86)
                .build();

        p1.addLineaPedido(lp1);

        pedidoRepository.save(p1);

        pedidoRepository.findAll().forEach(pedido -> pedido.getLineasPedido().forEach(lineaPedido -> System.out.println(  lineaPedido.getCantidad()+ lineaPedido.getId().toString() + lineaPedido.getPrecioVenta())));
    }
}
