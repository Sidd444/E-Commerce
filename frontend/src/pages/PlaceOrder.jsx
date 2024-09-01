import { useState } from 'react';
import axios from 'axios';

const PlaceOrder = () => {
  const [order, setOrder] = useState({ customerEmail: '', productId: '', cardUsed: '', cvv: '', requiredQuantity: '' });

  const handleChange = (e) => {
    setOrder({ ...order, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/order/place', order);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="p-8 bg-white shadow-md rounded-lg max-w-md mx-auto">
      <h2 className="text-3xl font-bold text-green-700 mb-6 text-center">Place Order</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          name="customerEmail"
          placeholder="Customer Email"
          value={order.customerEmail}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="productId"
          placeholder="Product ID"
          value={order.productId}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="cardUsed"
          placeholder="Card Used"
          value={order.cardUsed}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="cvv"
          placeholder="CVV"
          value={order.cvv}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="requiredQuantity"
          placeholder="Required Quantity"
          value={order.requiredQuantity}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <button
          type="submit"
          className="bg-green-600 text-white py-2 px-4 rounded-md w-full hover:bg-green-700 transition duration-300"
        >
          Place Order
        </button>
      </form>
    </div>
  );
};

export default PlaceOrder;
