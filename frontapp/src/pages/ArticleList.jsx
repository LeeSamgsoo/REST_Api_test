import { useEffect, useState } from 'react'

function ArticleList() {
    const [articleList, setArticleList] = useState([])

    useEffect(() => {
        fetch('http://localhost:8080/api/v1/articles')
            .then((res) => res.json())
            .then((res) => {
                console.log(res.data.articleList)
                setArticleList(res.data.articleList)
            })
    }, [])

    return (
        <>
            <ul>
                {articleList.map((article) => (
                    <li key={article.id}>
                        {article.id} / {article.subject} / {article.content} / {article.author}
                    </li>
                ))}
            </ul>
        </>
    )
}

export default ArticleList
