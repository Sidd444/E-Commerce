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
    <div className="p-4">
      <h2 className="text-xl mb-4">Place Order</h2>
      <form onSubmit={handleSubmit}>
        <input name="customerEmail" placeholder="Customer Email" value={order.customerEmail} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="productId" placeholder="Product ID" value={order.productId} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="cardUsed" placeholder="Card Used" value={order.cardUsed} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="cvv" placeholder="CVV" value={order.cvv} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="requiredQuantity" placeholder="Required Quantity" value={order.requiredQuantity} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <button type="submit" className="bg-blue-600 text-white p-2">Place Order</button>
      </form>
    </div>
  );
};

export default PlaceOrder;
