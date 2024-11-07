import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from './pages/Login'
import Main from './pages/Main'
import ArticleList from './pages/ArticleList'
import Nav from './pages/Nav'

function App() {
    return (
        <BrowserRouter>
            <Nav />
            <Routes>
                <Route index element={<Main />}></Route>
                <Route path="/auth/login" element={<Login />}></Route>
                <Route path="/article/list" element={<ArticleList />}></Route>
            </Routes>
        </BrowserRouter>
    )
}

export default App
