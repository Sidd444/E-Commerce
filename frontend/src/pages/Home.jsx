import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="p-8 ">
      <div className="max-w-4xl mx-auto text-center space-y-8">
        <h1 className="text-4xl font-bold text-green-700">Welcome to the E-Commerce Platform</h1>
        <div className="flex justify-between">
          <p className="text-lg text-green-600">
            Discover a wide range of products and services tailored to meet your needs. Our platform provides an excellent shopping experience with fast delivery and top-notch customer service.
          </p>

          <div className="flex justify-center mt-6">
            <img src="https://www.pinclipart.com/picdir/big/528-5280107_ecommerce-store-logo-png-clipart.png" alt="E-commerce Platform" className="w-3/4 md:w-1/2 rounded-lg shadow-lg" />
          </div>
        </div>
        <div className="space-y-4">
          <h2 className="text-2xl font-semibold text-green-800">Why Choose Us?</h2>
          <ul className="list-disc list-inside text-left text-green-700 mx-auto">
            <li>Wide variety of products from top brands</li>
            <li>Secure and easy payment options</li>
            <li>Fast and reliable delivery service</li>
            <li>Excellent customer support available 24/7</li>
          </ul>
        </div>

        <button className="bg-green-600 text-white py-2 px-6 rounded-md hover:bg-green-700 transition duration-300">
         <Link to="/add-seller" className='text-white font-bold text-xl'>Start Shopping</Link>
        </button>
      </div>
    </div>
  );
};

export default Home;
