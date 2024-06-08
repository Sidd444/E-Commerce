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
    <div className="p-4">
      <h2 className="text-xl mb-4">Add Customer</h2>
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={customer.name} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="emailId" placeholder="Email" value={customer.emailId} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="mobNo" placeholder="Mobile Number" value={customer.mobNo} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="gender" placeholder="Gender" value={customer.gender} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <button type="submit" className="bg-blue-600 text-white p-2">Add Customer</button>
      </form>
    </div>
  );
};

export default AddCustomer;
