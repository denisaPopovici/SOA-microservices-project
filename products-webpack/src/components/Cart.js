import React from 'react';
import './Cart.css';

const ProductCart = ({cart, closeCart}) => {

    const handlePostRequest = async () => {
        const mappedProducts = cart.map((item) => ({
            productCode: item.name,
            price: item.price,
            quantity: item.quantity,
        }));
        try {
            const response = await fetch('http://localhost:8080/api/purchase', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({
                    purchaseLineItemsDtoList: mappedProducts,
                }),
            });
        } catch (error) {
            console.error('Error during POST request:', error.message);
        }
    };

    return (
        <div className="product-cart">
            <div className="cart-header">
                <h2>Cosul de cumparaturi</h2>
                <button className="close-button" onClick={closeCart}>
                    &times;
                </button>
            </div>
            <div className="cart-items">
                {cart.map((product) => (
                    <div key={product.id} className="cart-item">
                        <h3>{product.name}</h3>
                        <p className="description">{product.description}</p>
                        <p className="price">Pret: {product.price} RON</p>
                        <p className="quantity">Cantitate: {product.quantity}</p>
                    </div>
                ))}
            </div>
            <div className="place-order-parent">
                <button className="place-order" onClick={handlePostRequest}>
                    Plaseaza comanda
                </button>
            </div>
        </div>
    );
};

export default ProductCart;
