import { useState } from 'react';
import axios from 'axios';

const AddCard = () => {
  const [card, setCard] = useState({ customerMobile: '', cardNo: '', cvv: '', validTill: '', cardType: '' });

  const handleChange = (e) => {
    setCard({ ...card, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/card/add', card);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-xl mb-4">Add Card</h2>
      <form onSubmit={handleSubmit}>
        <input name="customerMobile" placeholder="Customer Mobile" value={card.customerMobile} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="cardNo" placeholder="Card Number" value={card.cardNo} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="cvv" placeholder="CVV" value={card.cvv} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="validTill" placeholder="Valid Till" value={card.validTill} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <input name="cardType" placeholder="Card Type" value={card.cardType} onChange={handleChange} className="border p-2 mb-2 w-full" />
        <button type="submit" className="bg-blue-600 text-white p-2">Add Card</button>
      </form>
    </div>
  );
};

export default AddCard;
