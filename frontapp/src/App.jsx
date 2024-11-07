import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from './pages/Login'
import Main from './pages/Main'
import ArticleList from './pages/ArticleList'
import Nav from './pages/Nav'
import ArticleDetail from './pages/ArticleDetail'

function App() {
    return (
        <BrowserRouter>
            <Nav />
            <Routes>
                <Route index element={<Main />}></Route>
                <Route path="/auth/login" element={<Login />}></Route>
                <Route path="/article/list" element={<ArticleList />}></Route>
                <Route path="/article/detail/:id" element={<ArticleDetail />} />
            </Routes>
        </BrowserRouter>
    )
}

export default App
