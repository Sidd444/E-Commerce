import { useState } from 'react';
import axios from 'axios';

const AddCustomer = () => {
  const [customer, setCustomer] = useState({ name: '', emailId: '', mobNo: '', gender: '' });

  const handleChange = (e) => {
    setCustomer({ ...customer, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/customer/add', customer);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="p-8 bg-white shadow-md rounded-lg max-w-md mx-auto">
      <h2 className="text-3xl font-bold text-green-700 mb-6 text-center">Add Customer</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          name="name"
          placeholder="Name"
          value={customer.name}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="emailId"
          placeholder="Email"
          value={customer.emailId}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="mobNo"
          placeholder="Mobile Number"
          value={customer.mobNo}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="gender"
          placeholder="Gender"
          value={customer.gender}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <button
          type="submit"
          className="bg-green-600 text-white py-2 px-4 rounded-md w-full hover:bg-green-700 transition duration-300"
        >
          Add Customer
        </button>
      </form>
    </div>
  );
};

export default AddCustomer;
