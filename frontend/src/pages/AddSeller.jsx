import { useState } from 'react';
import axios from 'axios';

const AddSeller = () => {
  const [seller, setSeller] = useState({ name: '', emailId: '', panNo: '' });

  const handleChange = (e) => {
    setSeller({ ...seller, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/seller/add', seller);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="p-8 bg-white shadow-md rounded-lg max-w-md mx-auto">
      <h2 className="text-3xl font-bold text-green-700 mb-6 text-center">Add Seller</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          name="name"
          placeholder="Name"
          value={seller.name}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="emailId"
          placeholder="Email"
          value={seller.emailId}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="panNo"
          placeholder="PAN Number"
          value={seller.panNo}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <button type="submit" className="bg-green-600 text-white py-2 px-4 rounded-md w-full hover:bg-green-700 transition duration-300">
          Add Seller
        </button>
      </form>
    </div>
  );
};

export default AddSeller;
