// ProductList.js

import React from 'react';
import ProductCard from './ProductCard';
import './Product.css';

const ProductList = ({ products, addToCart }) => {
    return (
        <div className="product-list-container">
            {products.map((product) => (
                <ProductCard key={product.id} product={product} addToCart={addToCart} />
            ))}
        </div>
    );
};

export default ProductList;
