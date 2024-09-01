import { useState } from 'react';
import axios from 'axios';

const Cart = () => {
  const [item, setItem] = useState({ customerEmail: '', productId: '', requiredQuantity: '' });
  const [checkoutDetails, setCheckoutDetails] = useState({ customerEmail: '', cardNo: '', cvv: '' });

  const handleChange = (e) => {
    setItem({ ...item, [e.target.name]: e.target.value });
  };

  const handleCheckoutChange = (e) => {
    setCheckoutDetails({ ...checkoutDetails, [e.target.name]: e.target.value });
  };

  const handleAddToCart = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/cart/add', item);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleCheckout = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/cart/checkout', checkoutDetails);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="p-8 bg-white shadow-md rounded-lg max-w-4xl mx-auto mt-10 flex flex-col md:flex-row gap-8">
      <div className="flex-1 bg-gray-100 p-6 rounded-lg">
        <h2 className="text-3xl font-bold text-green-700 mb-6 text-center">Cart</h2>
        <form onSubmit={handleAddToCart} className="space-y-4">
          <input
            name="customerEmail"
            placeholder="Customer Email"
            value={item.customerEmail}
            onChange={handleChange}
            className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
          />
          <input
            name="productId"
            placeholder="Product ID"
            value={item.productId}
            onChange={handleChange}
            className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
          />
          <input
            name="requiredQuantity"
            placeholder="Required Quantity"
            value={item.requiredQuantity}
            onChange={handleChange}
            className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
          />
          <button
            type="submit"
            className="bg-green-600 text-white py-2 px-4 rounded-md w-full hover:bg-green-700 transition duration-300"
          >
            Add to Cart
          </button>
        </form>
      </div>

      <div className="flex-1 bg-gray-100 p-6 rounded-lg">
        <h2 className="text-3xl font-bold text-green-700 mb-6 text-center">Checkout</h2>
        <form onSubmit={handleCheckout} className="space-y-4">
          <input
            name="customerEmail"
            placeholder="Customer Email"
            value={checkoutDetails.customerEmail}
            onChange={handleCheckoutChange}
            className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
          />
          <input
            name="cardNo"
            placeholder="Card Number"
            value={checkoutDetails.cardNo}
            onChange={handleCheckoutChange}
            className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
          />
          <input
            name="cvv"
            placeholder="CVV"
            value={checkoutDetails.cvv}
            onChange={handleCheckoutChange}
            className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
          />
          <button
            type="submit"
            className="bg-green-600 text-white py-2 px-4 rounded-md w-full hover:bg-green-700 transition duration-300"
          >
            Checkout
          </button>
        </form>
      </div>
    </div>
  );
};

export default Cart;
