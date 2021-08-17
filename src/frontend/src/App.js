import React from 'react';
import {HashRouter as Router, Route, Switch, Link} from 'react-router-dom';
import './App.css';
import Country from './country/Country';
import Bookmark from "./bookmark/Bookmark";
import {Layout, Menu} from 'antd';
import {UserOutlined, NotificationOutlined} from '@ant-design/icons';

const {Header, Content, Footer, Sider} = Layout;


function App() {
  return (
    <Router>
      <Layout style={{minHeight: '100vh'}}>
        <Sider
          breakpoint="lg"
          collapsedWidth="0"
          onBreakpoint={broken => {
            console.log(broken);
          }}
          onCollapse={(collapsed, type) => {
            console.log(collapsed, type);
          }}
        >
          <Menu theme="dark" mode="inline" defaultSelectedKeys={[window.location.hash || '#/']}>
            <Menu.Item key="#/" icon={<UserOutlined/>}>
              <span>Home</span>
              <Link to="/"/>
            </Menu.Item>
            <Menu.Item key="#/bookmark" icon={<NotificationOutlined/>}>
              <span>Bookmark</span>
              <Link to="/bookmark"/>
            </Menu.Item>
          </Menu>
        </Sider>
        <Layout>
          <Header className="site-layout-sub-header-background" style={{padding: 0}}>
            Welcome to World Map
          </Header>
          <Content style={{margin: '24px 16px 0'}}>
            <div className="site-layout-background" style={{padding: 24, minHeight: 360}}>
              <Switch>
                <Route exact path="/">
                  <Country/>
                </Route>
                <Route exact path="/bookmark">
                  <Bookmark/>
                </Route>
              </Switch>

            </div>
          </Content>
          <Footer style={{textAlign: 'center'}}>World Map Application. All Rights
            Reserved {new Date().getFullYear()}</Footer>
        </Layout>
      </Layout>
    </Router>
  );
}

export default App;
