import {Descriptions, Button, message} from 'antd';
import React, {Component} from "react";
import axios from "axios";

class Bookmark extends Component {

  state = {
    groups: []
  };

  componentDidMount() {
    axios.get("v1.0/bookmark")
      .then((response) => this.setState({groups: response.data}))
      .catch(function (error) {
        console.error(error.toString());
      });
  }

  unBookmarkCountry(obj) {
    axios.delete("v1.0/bookmark?code="+obj.code)
      .then((response) => this.setState({groups: []}))
      .catch(function (error) {
        message.error(error.toString());
      });
  }

  render() {
    const {groups} = this.state;
    return (
      <Descriptions title="Bookmarked Country" bordered>
        <Descriptions.Item label="Name">{groups.name}</Descriptions.Item>
        <Descriptions.Item label="Continent">{groups.continent}</Descriptions.Item>
        <Descriptions.Item label="Population">{groups.population}</Descriptions.Item>
        <Descriptions.Item label="Life Expectancy">{groups.lifeExpectancy}</Descriptions.Item>
        <Descriptions.Item label="Country Language">{groups.countryLanguage}</Descriptions.Item>
        <Descriptions.Item label="Remove Bookmark">
          <Button danger onClick={() => {
            this.unBookmarkCountry(groups);
          }} type="primary" htmlType="submit">
            Remove
          </Button>
        </Descriptions.Item>
      </Descriptions>
    );
  }

}

export default Bookmark;