import { useState } from 'react';
import axios from 'axios';

const AddProduct = () => {
  const [product, setProduct] = useState({ sellerEmail: '', productName: '', price: '', availableQuantity: '', category: '' });

  const handleChange = (e) => {
    setProduct({ ...product, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/product/add', product);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-xl mb-4">Add Product</h2>
      <form onSubmit={handleSubmit}>
        <input name="sellerEmail" placeholder="Seller Email" value={product.sellerEmail} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="productName" placeholder="Product Name" value={product.productName} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="price" placeholder="Price" value={product.price} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="availableQuantity" placeholder="Available Quantity" value={product.availableQuantity} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="category" placeholder="Category" value={product.category} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <button type="submit" className="bg-blue-600 text-white p-2">Add Product</button>
      </form>
    </div>
  );
};

export default AddProduct;
