import React from 'react';
import './Product.css';

const ProductCard = ({ product, addToCart }) => {
    return (
        <div className="product-container">
            <h3 className="product-name">{product.name}</h3>
            <p className="product-description">{product.description}</p>
            <p className="product-price">Pret: {product.price} RON</p>
            <button className="add-to-cart-button" onClick={() => addToCart(product)}>
                Adauga in cos
            </button>
        </div>
    );
};

export default ProductCard;
