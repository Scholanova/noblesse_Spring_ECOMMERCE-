package com.scholanova.ecommerce.cart.service;

import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.product.entity.Product;
import com.scholanova.ecommerce.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class CartServiceImpl implements CartService{

    ProductRepository productRepository;

    @Override
    public Cart addProductToCart(Cart cart, Long productId, int quantity) {
        //TODO
        //je recupère le produit par id "productId"
        Product product = productRepository.findById(productId).get();
        //je l'ajoute dans la cart avec sa quantité
        return cart.addProduct(product, quantity);
    }

    @Override
    public Cart changeProductQuantity(Cart cart, Long productId, int quantity) {
        //TODO
        //je recupère le produit par id "productId"
        Product product = productRepository.findById(productId).get();
        //je change la quantité du produit dans la carte
        return cart.changeProductQuantity(product, quantity);
    }
}
