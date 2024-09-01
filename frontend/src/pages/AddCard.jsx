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
    <div className="p-8 bg-white shadow-md rounded-lg max-w-lg mx-auto">
      <h2 className="text-3xl font-bold text-green-700 mb-6 text-center">Add Card</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          name="customerMobile"
          placeholder="Customer Mobile"
          value={card.customerMobile}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="cardNo"
          placeholder="Card Number"
          value={card.cardNo}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="cvv"
          placeholder="CVV"
          value={card.cvv}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="validTill"
          placeholder="Valid Till"
          value={card.validTill}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <input
          name="cardType"
          placeholder="Card Type"
          value={card.cardType}
          onChange={handleChange}
          className="border border-green-400 rounded-md p-3 w-full text-green-800 focus:outline-none focus:ring-2 focus:ring-green-600"
        />
        <button
          type="submit"
          className="bg-green-600 text-white py-2 px-4 rounded-md w-full hover:bg-green-700 transition duration-300"
        >
          Add Card
        </button>
      </form>
    </div>
  );
};

export default AddCard;
