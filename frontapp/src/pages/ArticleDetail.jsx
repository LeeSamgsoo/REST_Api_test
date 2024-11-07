import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

function ArticleDetail() {
    const { id } = useParams() // URL의 {id} 부분을 가져옴
    const [article, setArticle] = useState({})

    useEffect(() => {
        fetch(`http://localhost:8080/api/v1/articles/${id}`)
            .then((res) => res.json())
            .then((res) => {
                console.log(res.data.article)
                setArticle(res.data.article)
            })
    }, [id])

    return (
        <>
            <ul>
                <li key={article.id}>
                    {article.id} / {article.subject} / {article.content} / {article.author}
                </li>
            </ul>
        </>
    )
}

export default ArticleDetail
