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
    <div className="p-8 bg-white shadow-md rounded-lg max-w-md mx-auto">
      <h2 className="text-3xl font-bold text-green-700 mb-6 text-center">Add Product</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          name="sellerEmail"
          placeholder="Seller Email"
          value={product.sellerEmail}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="productName"
          placeholder="Product Name"
          value={product.productName}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="price"
          placeholder="Price"
          value={product.price}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="availableQuantity"
          placeholder="Available Quantity"
          value={product.availableQuantity}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="category"
          placeholder="Category"
          value={product.category}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <button
          type="submit"
          className="bg-green-600 text-white py-2 px-4 rounded-md w-full hover:bg-green-700 transition duration-300"
        >
          Add Product
        </button>
      </form>
    </div>
  );
};

export default AddProduct;
