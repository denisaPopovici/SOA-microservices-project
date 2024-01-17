import React, { useState, useEffect } from 'react';
import ProductList from "./ProductList";
import Header from "./Header";
import ProductCart from "./Cart";

const PharmacyMainPage = () => {
    const [products, setProducts] = useState([]);
    const [cart, setCart] = useState([]);
    const [isCartOpen, setIsCartOpen] = useState(false);

    useEffect(() => {
        fetch('http://localhost:8080/api/product',{
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
        } )
            .then(response => response.json())
            .then(data => {
                console.log(data);
                setProducts(data);
            })
            .catch(error => console.error('Error fetching products:', error));
    }, []);

    const openCart = () => {
        setIsCartOpen(true);
    };

    const closeCart = () => {
        console.log("Closing cart....")
        setIsCartOpen(false);
    };

    const addToCart = (product) => {
        const existingItemIndex = cart.findIndex(
            (item) => item.name === product.name
        );

        if (existingItemIndex !== -1) {
            // If product is already in the cart, update the quantity
            const updatedCartItems = [...cart];
            updatedCartItems[existingItemIndex].quantity += 1;
            setCart(updatedCartItems);
        } else {
            product.quantity = 1;
            setCart((prevItems) => [...prevItems, product]);
        }
    };

    return (
        <div>
            <Header openCart={openCart}/>
            <ProductList products={products} addToCart={addToCart}/>
            {isCartOpen && (
                <ProductCart cart={cart} closeCart={closeCart} />
            )}
        </div>
);
};

export default PharmacyMainPage;
