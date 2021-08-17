import {Input, Table, Button, Form, message} from 'antd';
import React, {Component} from "react";
import './Country.css'
import axios from "axios";

class Country extends Component {

  columns = [
    {
      title: 'Name',
      dataIndex: 'name',
      key: 'name'
    },
    {
      title: 'Continent',
      dataIndex: 'continent',
      key: 'continent'
    },
    {
      title: 'Population',
      dataIndex: 'population',
      key: 'population'
    },
    {
      title: 'Life Expectancy',
      dataIndex: 'lifeExpectancy',
      key: 'lifeExpectancy'
    },
    {
      title: "Country Language",
      dataIndex: 'countryLanguage',
      key: 'countryLanguage'
    },
    {
      title: 'Action',
      key: 'operation',
      fixed: 'right',
      width: 100,
      render: () => (
        <Button onClick={() => {
          this.bookmarkCountry();
        }} type="primary" htmlType="submit">
          Bookmark
        </Button>
      )
    }
  ];


  state = {
    searchKey:"",
    isLoading: false,
    groups: []
  };

  formRef = React.createRef();


  updateTextboxVal = (event) => {
    this.setState({searchKey: event.target.value});
  };

  bookmarkCountry(){
    axios.put("v1.0/bookmark?code="+this.state.searchKey)
      .then(function (response) {
        message.success("Bookmarked")
      })
      .catch(function (error) {
        console.error(error.toString());
      });
  }

  fetchCountryByCode= ()=> {
    this.setState({isLoading: true});
    axios.get("v1.0/country?code=" + this.state.searchKey)
      .then((response) => this.setState({groups: response.data, isLoading: false}))
      .catch((err)=>{
        this.setState({groups: [], isLoading: false});
        message.error(err.toString());
      })
  }

    render() {
      const {groups, isLoading} = this.state;
      return (
        <div>
        <div>
          <Form ref={this.formRef}
            name="basic"
                onFinish={this.fetchCountryByCode} >
            <Form.Item
              name="search"
              rules={[{required: true, message: 'Please enter country code!'}]}>
              <Input placeholder="Enter country code" onChange={event=> this.updateTextboxVal(event)}/>
            </Form.Item>
            <Form.Item>
              <Button className="submitBtn" loading={isLoading}
                      type="primary" htmlType="submit">
                Submit
              </Button>
            </Form.Item>
          </Form>
          </div>
        <Table columns={this.columns} dataSource={groups}/>
        </div>
      );
    }
}

export default Country;