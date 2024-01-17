import React, { useState } from 'react';
import './AddProductPage.css';

const AddProductPage = () => {
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [price, setPrice] = useState(0);


    const handleAddProduct = async () => {
        console.log('Adding new product ' + JSON.stringify({
            name,
            description,
            price
        }));

        try {
            const response = await fetch('http://localhost:8080/api/product', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({
                    name,
                    description,
                    price
                }),
            })
        } catch (error) {
            console.log("Error adding product: ", error.message)
        }
    };

    const handlePublishMessage = async () => {
        console.log('Publishing message for new product');

        try {
            const response = await fetch('http://localhost:8080/api/product/publish', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({
                    productName: name
                }),
            })
        } catch (error) {
            console.log("Error publishing message: ", error.message)
        }
    };

    return (
        <div className="container">
            <h2>Add a New Product</h2>
            <div className="form">
                <label>
                    Product Name:
                    <input
                        type="text"
                        onChange={e => setName(e.target.value)}
                        defaultValue={name}
                    />
                </label>
                <label>
                    Product Description:
                    <textarea
                        onChange={e => setDescription(e.target.value)}
                        defaultValue={description}
                    />
                </label>
                <label>
                    Product Price:
                    <input
                        type="number"
                        defaultValue={price}
                        onChange={e => setPrice(parseFloat(e.target.value))}
                    />
                </label>
                <button onClick={() => {
                    handleAddProduct().then(handlePublishMessage);}
                }>
                    Add Product
                </button>
            </div>
        </div>
    );
};

export default AddProductPage;
