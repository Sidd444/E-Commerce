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
    <div className="p-4">
      <h2 className="text-xl mb-4">Add Seller</h2>
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={seller.name} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="emailId" placeholder="Email" value={seller.emailId} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="panNo" placeholder="PAN Number" value={seller.panNo} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <button type="submit" className="bg-blue-600 text-white p-2">Add Seller</button>
      </form>
    </div>
  );
};

export default AddSeller;
