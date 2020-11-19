import React from 'react'
import {ArticleMenu as Menu} from '../components'
import './table.style.css'

const Article = ({children}) => (<>
    <h1>Articles</h1>
    <Menu/>
    {children}
</>)

export default Article
