import React, { useState } from 'react';
import productService from '../Service/product_service';

const AddProduct = () => {
  const [product, setProduct] = useState({
    name: '',
    phoneNumber: '',
    email: '',
    hobbies: '',
  });

  const [msg,setMsg]=useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevProduct) => ({
      ...prevProduct,
      [name]: value,
    }));
  };

  const productRegister = (e) => {
    e.preventDefault();
    productService
      .saveProduct(product)
      .then((res) => {
        console.log('Product added successfully');
        setMsg("Congratulations your successfully");
        setProduct({
          name: '',
          phoneNumber: '',
          email: '',
          hobbies: '',
        })
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
     <div className="container mt-3">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-header fs-3 text-center">Add Name</div>
            {
              msg &&
               <p className='fs-4 text-center text-success '>{msg}</p>
            }
            <div className="card-body">
              <form onSubmit={(e)=>productRegister(e)}>
                <div className="mb-3">
                  <label htmlFor="productName">Enter name</label>
                  <input required
                    type="text"
                    id="productName"
                    name="name"
                    className="form-control"
                    value={product.name}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="description">Enter PhoneNumber</label>
                  <input required
                    type="text"
                    id="description"
                    name="phoneNumber"
                    className="form-control"
                    value={product.phoneNumber}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="price">Enter Email</label>
                  <input required
                    type="text"
                    id="price"
                    name="email"
                    className="form-control"
                    value={product.email}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="status">Enter Hobbies</label>
                  <input required
                    type="text"
                    id="status"
                    name="hobbies"
                    className="form-control"
                    value={product.hobbies}
                    onChange={handleChange}
                  />
                </div>
                <button type="submit" className="btn btn-primary col-md-12">
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddProduct;