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
    <div className="p-4">
      <h2 className="text-xl mb-4">Cart</h2>
      <form onSubmit={handleAddToCart}>
        <input name="customerEmail" placeholder="Customer Email" value={item.customerEmail} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="productId" placeholder="Product ID" value={item.productId} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="requiredQuantity" placeholder="Required Quantity" value={item.requiredQuantity} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <button type="submit" className="bg-blue-600 text-white p-2">Add to Cart</button>
      </form>

      <h2 className="text-xl mb-4 mt-4">Checkout</h2>
      <form onSubmit={handleCheckout}>
        <input name="customerEmail" placeholder="Customer Email" value={checkoutDetails.customerEmail} onChange={handleCheckoutChange} className="border p-2 mb-2 w-full" />
        <input name="cardNo" placeholder="Card Number" value={checkoutDetails.cardNo} onChange={handleCheckoutChange} className="border p-2 mb-2 w-full" />
        <input name="cvv" placeholder="CVV" value={checkoutDetails.cvv} onChange={handleCheckoutChange} className="border p-2 mb-2 w-full" />
        <button type="submit" className="bg-blue-600 text-white p-2">Checkout</button>
      </form>
    </div>
  );
};

export default Cart;
