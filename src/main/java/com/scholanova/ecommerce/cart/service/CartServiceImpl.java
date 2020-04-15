package com.scholanova.ecommerce.cart.service;

import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.cart.exception.CartException;
import com.scholanova.ecommerce.product.entity.Product;
import com.scholanova.ecommerce.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class CartServiceImpl implements CartService{

    ProductRepository productRepository;

    @Override
    public Cart addProductToCart(Cart cart, Long productId, int quantity) throws CartException {
        //TODO
        //Je gère les exceptions avec try et catch

        //Si tout va bien, try
        try{
            //je recupère le produit par id "productId"
            Product myProduct = productRepository.findById(productId).get();

            //je l'ajoute dans la cart avec sa quantité
            return cart.addProduct(myProduct, quantity);
        }
        //sinon,afficher une exception avec le message de l'echec de l'ajout

        catch ( Exception e ) {
            throw new CartException("L'ajout du produit dans la carte a echoue");
        }
    }

    @Override
    public Cart changeProductQuantity(Cart cart, Long productId, int quantity) throws CartException {
        //TODO
        //Je gère les exceptions avec try et catch

        //Si tout va bien, try
        try {
            //je recupère le produit par id "productId"
            Product myProduct = productRepository.findById(productId).get();

            //je change la quantité du produit dans la carte
            return cart.changeProductQuantity(myProduct, quantity);
        }

        //sinon,afficher une exception avec le message de l'echec du changement de quantité

        catch (Exception e) {
            throw new CartException("Le changement de la quantity du produit dans la carte a echoue");
        }
    }
}
