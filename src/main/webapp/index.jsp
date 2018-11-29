<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width initial-scale=1'>
    <title>ReadMe</title>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,700,400&subset=latin,latin-ext'
          rel='stylesheet' type='text/css'/>
    <style type='text/css'>html {
        overflow-x: initial !important;
    }

    :root {
        --bg-color: #ffffff;
        --text-color: #333333;
        --select-text-bg-color: #B5D6FC;
        --select-text-font-color: auto;
        --monospace: "Lucida Console", Consolas, "Courier", monospace;
    }

    html {
        font-size: 14px;
        background-color: var(--bg-color);
        color: var(--text-color);
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
    }

    body {
        margin: 0px;
        padding: 0px;
        height: auto;
        bottom: 0px;
        top: 0px;
        left: 0px;
        right: 0px;
        font-size: 1rem;
        line-height: 1.42857;
        overflow-x: hidden;
        background: inherit;
    }

    iframe {
        margin: auto;
    }

    a.url {
        word-break: break-all;
    }

    a:active, a:hover {
        outline: 0px;
    }

    .in-text-selection, ::selection {
        text-shadow: none;
        background: var(--select-text-bg-color);
        color: var(--select-text-font-color);
    }

    #write {
        margin: 0px auto;
        height: auto;
        width: inherit;
        word-break: normal;
        word-wrap: break-word;
        position: relative;
        white-space: normal;
        padding-bottom: 70px;
        overflow-x: visible;
    }

    .first-line-indent #write div, .first-line-indent #write li, .first-line-indent #write p {
        text-indent: 2em;
    }

    .first-line-indent #write div :not(p):not(div), .first-line-indent #write div.md-htmlblock-container, .first-line-indent #write p *, .first-line-indent pre {
        text-indent: 0px;
    }

    .for-image #write {
        padding-left: 8px;
        padding-right: 8px;
    }

    body.typora-export {
        padding-left: 30px;
        padding-right: 30px;
    }

    @media screen and (max-width: 500px) {
        body.typora-export {
            padding-left: 0px;
            padding-right: 0px;
        }

        .CodeMirror-sizer {
            margin-left: 0px !important;
        }

        .CodeMirror-gutters {
            display: none !important;
        }
    }

    #write > blockquote:first-child, #write > div:first-child, #write > figure:first-child, #write > ol:first-child, #write > p:first-child, #write > pre:first-child, #write > ul:first-child {
        margin-top: 30px;
    }

    #write li > figure:first-child {
        margin-top: -20px;
    }

    #write ol, #write ul {
        position: relative;
    }

    img {
        max-width: 100%;
        vertical-align: middle;
    }

    button, input, select, textarea {
        color: inherit;
        font-style: inherit;
        font-variant: inherit;
        font-weight: inherit;
        font-stretch: inherit;
        font-size: inherit;
        line-height: inherit;
        font-family: inherit;
    }

    input[type="checkbox"], input[type="radio"] {
        line-height: normal;
        padding: 0px;
    }

    *, ::after, ::before {
        box-sizing: border-box;
    }

    #write h1, #write h2, #write h3, #write h4, #write h5, #write h6, #write p, #write pre {
        width: inherit;
    }

    #write h1, #write h2, #write h3, #write h4, #write h5, #write h6, #write p {
        position: relative;
    }

    h1, h2, h3, h4, h5, h6 {
        break-after: avoid-page;
        break-inside: avoid;
        orphans: 2;
    }

    p {
        orphans: 4;
    }

    h1 {
        font-size: 2rem;
    }

    h2 {
        font-size: 1.8rem;
    }

    h3 {
        font-size: 1.6rem;
    }

    h4 {
        font-size: 1.4rem;
    }

    h5 {
        font-size: 1.2rem;
    }

    h6 {
        font-size: 1rem;
    }

    .md-math-block, .md-rawblock, h1, h2, h3, h4, h5, h6, p {
        margin-top: 1rem;
        margin-bottom: 1rem;
    }

    .hidden {
        display: none;
    }

    .md-blockmeta {
        color: rgb(204, 204, 204);
        font-weight: 700;
        font-style: italic;
    }

    a {
        cursor: pointer;
    }

    sup.md-footnote {
        padding: 2px 4px;
        background-color: rgba(238, 238, 238, 0.7);
        color: rgb(85, 85, 85);
        border-radius: 4px;
        cursor: pointer;
    }

    sup.md-footnote a, sup.md-footnote a:hover {
        color: inherit;
        text-transform: inherit;
        text-decoration: inherit;
    }

    #write input[type="checkbox"] {
        cursor: pointer;
        width: inherit;
        height: inherit;
    }

    figure {
        overflow-x: auto;
        margin: 1.2em 0px;
        max-width: calc(100% + 16px);
        padding: 0px;
    }

    figure > table {
        margin: 0px !important;
    }

    tr {
        break-inside: avoid;
        break-after: auto;
    }

    thead {
        display: table-header-group;
    }

    table {
        border-collapse: collapse;
        border-spacing: 0px;
        width: 100%;
        overflow: auto;
        break-inside: auto;
        text-align: left;
    }

    table.md-table td {
        min-width: 80px;
    }

    .CodeMirror-gutters {
        border-right: 0px;
        background-color: inherit;
    }

    .CodeMirror {
        text-align: left;
    }

    .CodeMirror-placeholder {
        opacity: 0.3;
    }

    .CodeMirror pre {
        padding: 0px 4px;
    }

    .CodeMirror-lines {
        padding: 0px;
    }

    div.hr:focus {
        cursor: none;
    }

    #write pre {
        white-space: pre-wrap;
    }

    #write.fences-no-line-wrapping pre {
        white-space: pre;
    }

    #write pre.ty-contain-cm {
        white-space: normal;
    }

    .CodeMirror-gutters {
        margin-right: 4px;
    }

    .md-fences {
        font-size: 0.9rem;
        display: block;
        break-inside: avoid;
        text-align: left;
        overflow: visible;
        white-space: pre;
        background: inherit;
        position: relative !important;
    }

    .md-diagram-panel {
        width: 100%;
        margin-top: 10px;
        text-align: center;
        padding-top: 0px;
        padding-bottom: 8px;
        overflow-x: auto;
    }

    #write .md-fences.mock-cm {
        white-space: pre-wrap;
    }

    .md-fences.md-fences-with-lineno {
        padding-left: 0px;
    }

    #write.fences-no-line-wrapping .md-fences.mock-cm {
        white-space: pre;
        overflow-x: auto;
    }

    .md-fences.mock-cm.md-fences-with-lineno {
        padding-left: 8px;
    }

    .CodeMirror-line, twitterwidget {
        break-inside: avoid;
    }

    .footnotes {
        opacity: 0.8;
        font-size: 0.9rem;
        margin-top: 1em;
        margin-bottom: 1em;
    }

    .footnotes + .footnotes {
        margin-top: 0px;
    }

    .md-reset {
        margin: 0px;
        padding: 0px;
        border: 0px;
        outline: 0px;
        vertical-align: top;
        background: 0px 0px;
        text-decoration: none;
        text-shadow: none;
        float: none;
        position: static;
        width: auto;
        height: auto;
        white-space: nowrap;
        cursor: inherit;
        -webkit-tap-highlight-color: transparent;
        line-height: normal;
        font-weight: 400;
        text-align: left;
        box-sizing: content-box;
        direction: ltr;
    }

    li div {
        padding-top: 0px;
    }

    blockquote {
        margin: 1rem 0px;
    }

    li .mathjax-block, li p {
        margin: 0.5rem 0px;
    }

    li {
        margin: 0px;
        position: relative;
    }

    blockquote > :last-child {
        margin-bottom: 0px;
    }

    blockquote > :first-child, li > :first-child {
        margin-top: 0px;
    }

    .footnotes-area {
        color: rgb(136, 136, 136);
        margin-top: 0.714rem;
        padding-bottom: 0.143rem;
        white-space: normal;
    }

    #write .footnote-line {
        white-space: pre-wrap;
    }

    @media print {
        body, html {
            border: 1px solid transparent;
            height: 99%;
            break-after: avoid;
            break-before: avoid;
        }

        #write {
            margin-top: 0px;
            border-color: transparent !important;
        }

        .typora-export * {
            -webkit-print-color-adjust: exact;
        }

        html.blink-to-pdf {
            font-size: 13px;
        }

        .typora-export #write {
            padding-left: 1cm;
            padding-right: 1cm;
            padding-bottom: 0px;
            break-after: avoid;
        }

        .typora-export #write::after {
            height: 0px;
        }

        @page {
            margin: 20mm 0px;
        }
    }

    .footnote-line {
        margin-top: 0.714em;
        font-size: 0.7em;
    }

    a img, img a {
        cursor: pointer;
    }

    pre.md-meta-block {
        font-size: 0.8rem;
        min-height: 0.8rem;
        white-space: pre-wrap;
        background: rgb(204, 204, 204);
        display: block;
        overflow-x: hidden;
    }

    p > img:only-child {
        display: block;
        margin: auto;
    }

    p > .md-image:only-child {
        display: inline-block;
        width: 100%;
        text-align: center;
    }

    #write .MathJax_Display {
        margin: 0.8em 0px 0px;
    }

    .md-math-block {
        width: 100%;
    }

    .md-math-block:not(:empty)::after {
        display: none;
    }

    [contenteditable="true"]:active, [contenteditable="true"]:focus {
        outline: 0px;
        box-shadow: none;
    }

    .md-task-list-item {
        position: relative;
        list-style-type: none;
    }

    .task-list-item.md-task-list-item {
        padding-left: 0px;
    }

    .md-task-list-item > input {
        position: absolute;
        top: 0px;
        left: 0px;
        margin-left: -1.2em;
        margin-top: calc(1em - 10px);
    }

    .math {
        font-size: 1rem;
    }

    .md-toc {
        min-height: 3.58rem;
        position: relative;
        font-size: 0.9rem;
        border-radius: 10px;
    }

    .md-toc-content {
        position: relative;
        margin-left: 0px;
    }

    .md-toc-content::after, .md-toc::after {
        display: none;
    }

    .md-toc-item {
        display: block;
        color: rgb(65, 131, 196);
    }

    .md-toc-item a {
        text-decoration: none;
    }

    .md-toc-inner:hover {
    }

    .md-toc-inner {
        display: inline-block;
        cursor: pointer;
    }

    .md-toc-h1 .md-toc-inner {
        margin-left: 0px;
        font-weight: 700;
    }

    .md-toc-h2 .md-toc-inner {
        margin-left: 2em;
    }

    .md-toc-h3 .md-toc-inner {
        margin-left: 4em;
    }

    .md-toc-h4 .md-toc-inner {
        margin-left: 6em;
    }

    .md-toc-h5 .md-toc-inner {
        margin-left: 8em;
    }

    .md-toc-h6 .md-toc-inner {
        margin-left: 10em;
    }

    @media screen and (max-width: 48em) {
        .md-toc-h3 .md-toc-inner {
            margin-left: 3.5em;
        }

        .md-toc-h4 .md-toc-inner {
            margin-left: 5em;
        }

        .md-toc-h5 .md-toc-inner {
            margin-left: 6.5em;
        }

        .md-toc-h6 .md-toc-inner {
            margin-left: 8em;
        }
    }

    a.md-toc-inner {
        font-size: inherit;
        font-style: inherit;
        font-weight: inherit;
        line-height: inherit;
    }

    .footnote-line a:not(.reversefootnote) {
        color: inherit;
    }

    .md-attr {
        display: none;
    }

    .md-fn-count::after {
        content: ".";
    }

    code, pre, samp, tt {
        font-family: var(--monospace);
    }

    kbd {
        margin: 0px 0.1em;
        padding: 0.1em 0.6em;
        font-size: 0.8em;
        color: rgb(36, 39, 41);
        background: rgb(255, 255, 255);
        border: 1px solid rgb(173, 179, 185);
        border-radius: 3px;
        box-shadow: rgba(12, 13, 14, 0.2) 0px 1px 0px, rgb(255, 255, 255) 0px 0px 0px 2px inset;
        white-space: nowrap;
        vertical-align: middle;
    }

    .md-comment {
        color: rgb(162, 127, 3);
        opacity: 0.8;
        font-family: var(--monospace);
    }

    code {
        text-align: left;
        vertical-align: initial;
    }

    a.md-print-anchor {
        white-space: pre !important;
        border-width: initial !important;
        border-style: none !important;
        border-color: initial !important;
        display: inline-block !important;
        position: absolute !important;
        width: 1px !important;
        right: 0px !important;
        outline: 0px !important;
        background: 0px 0px !important;
        text-decoration: initial !important;
        text-shadow: initial !important;
    }

    .md-inline-math .MathJax_SVG .noError {
        display: none !important;
    }

    .md-math-block .MathJax_SVG_Display {
        text-align: center;
        margin: 0px;
        position: relative;
        text-indent: 0px;
        max-width: none;
        max-height: none;
        min-height: 0px;
        min-width: 100%;
        width: auto;
        overflow-y: hidden;
        display: block !important;
    }

    .MathJax_SVG_Display, .md-inline-math .MathJax_SVG_Display {
        width: auto;
        margin: inherit;
        display: inline-block !important;
    }

    .MathJax_SVG .MJX-monospace {
        font-family: var(--monospace);
    }

    .MathJax_SVG .MJX-sans-serif {
        font-family: sans-serif;
    }

    .MathJax_SVG {
        display: inline;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        zoom: 90%;
        text-indent: 0px;
        text-align: left;
        text-transform: none;
        letter-spacing: normal;
        word-spacing: normal;
        word-wrap: normal;
        white-space: nowrap;
        float: none;
        direction: ltr;
        max-width: none;
        max-height: none;
        min-width: 0px;
        min-height: 0px;
        border: 0px;
        padding: 0px;
        margin: 0px;
    }

    .MathJax_SVG * {
        transition: none;
    }

    .MathJax_SVG_Display svg {
        vertical-align: middle !important;
        margin-bottom: 0px !important;
    }

    .os-windows.monocolor-emoji .md-emoji {
        font-family: "Segoe UI Symbol", sans-serif;
    }

    .md-diagram-panel > svg {
        max-width: 100%;
    }

    [lang="mermaid"] svg, [lang="flow"] svg {
        max-width: 100%;
    }

    [lang="mermaid"] .node text {
        font-size: 1rem;
    }

    table tr th {
        border-bottom: 0px;
    }

    video {
        max-width: 100%;
        display: block;
        margin: 0px auto;
    }

    iframe {
        max-width: 100%;
        width: 100%;
        border: none;
    }

    .highlight td, .highlight tr {
        border: 0px;
    }

    .CodeMirror {
        height: auto;
    }

    .CodeMirror.cm-s-inner {
        background: inherit;
    }

    .CodeMirror-scroll {
        overflow-y: hidden;
        overflow-x: auto;
        z-index: 3;
    }

    .CodeMirror-gutter-filler, .CodeMirror-scrollbar-filler {
        background-color: rgb(255, 255, 255);
    }

    .CodeMirror-gutters {
        border-right: 1px solid rgb(221, 221, 221);
        background: inherit;
        white-space: nowrap;
    }

    .CodeMirror-linenumber {
        padding: 0px 3px 0px 5px;
        text-align: right;
        color: rgb(153, 153, 153);
    }

    .cm-s-inner .cm-keyword {
        color: rgb(119, 0, 136);
    }

    .cm-s-inner .cm-atom, .cm-s-inner.cm-atom {
        color: rgb(34, 17, 153);
    }

    .cm-s-inner .cm-number {
        color: rgb(17, 102, 68);
    }

    .cm-s-inner .cm-def {
        color: rgb(0, 0, 255);
    }

    .cm-s-inner .cm-variable {
        color: rgb(0, 0, 0);
    }

    .cm-s-inner .cm-variable-2 {
        color: rgb(0, 85, 170);
    }

    .cm-s-inner .cm-variable-3 {
        color: rgb(0, 136, 85);
    }

    .cm-s-inner .cm-string {
        color: rgb(170, 17, 17);
    }

    .cm-s-inner .cm-property {
        color: rgb(0, 0, 0);
    }

    .cm-s-inner .cm-operator {
        color: rgb(152, 26, 26);
    }

    .cm-s-inner .cm-comment, .cm-s-inner.cm-comment {
        color: rgb(170, 85, 0);
    }

    .cm-s-inner .cm-string-2 {
        color: rgb(255, 85, 0);
    }

    .cm-s-inner .cm-meta {
        color: rgb(85, 85, 85);
    }

    .cm-s-inner .cm-qualifier {
        color: rgb(85, 85, 85);
    }

    .cm-s-inner .cm-builtin {
        color: rgb(51, 0, 170);
    }

    .cm-s-inner .cm-bracket {
        color: rgb(153, 153, 119);
    }

    .cm-s-inner .cm-tag {
        color: rgb(17, 119, 0);
    }

    .cm-s-inner .cm-attribute {
        color: rgb(0, 0, 204);
    }

    .cm-s-inner .cm-header, .cm-s-inner.cm-header {
        color: rgb(0, 0, 255);
    }

    .cm-s-inner .cm-quote, .cm-s-inner.cm-quote {
        color: rgb(0, 153, 0);
    }

    .cm-s-inner .cm-hr, .cm-s-inner.cm-hr {
        color: rgb(153, 153, 153);
    }

    .cm-s-inner .cm-link, .cm-s-inner.cm-link {
        color: rgb(0, 0, 204);
    }

    .cm-negative {
        color: rgb(221, 68, 68);
    }

    .cm-positive {
        color: rgb(34, 153, 34);
    }

    .cm-header, .cm-strong {
        font-weight: 700;
    }

    .cm-del {
        text-decoration: line-through;
    }

    .cm-em {
        font-style: italic;
    }

    .cm-link {
        text-decoration: underline;
    }

    .cm-error {
        color: red;
    }

    .cm-invalidchar {
        color: red;
    }

    .cm-constant {
        color: rgb(38, 139, 210);
    }

    .cm-defined {
        color: rgb(181, 137, 0);
    }

    div.CodeMirror span.CodeMirror-matchingbracket {
        color: rgb(0, 255, 0);
    }

    div.CodeMirror span.CodeMirror-nonmatchingbracket {
        color: rgb(255, 34, 34);
    }

    .cm-s-inner .CodeMirror-activeline-background {
        background: inherit;
    }

    .CodeMirror {
        position: relative;
        overflow: hidden;
    }

    .CodeMirror-scroll {
        height: 100%;
        outline: 0px;
        position: relative;
        box-sizing: content-box;
        background: inherit;
    }

    .CodeMirror-sizer {
        position: relative;
    }

    .CodeMirror-gutter-filler, .CodeMirror-hscrollbar, .CodeMirror-scrollbar-filler, .CodeMirror-vscrollbar {
        position: absolute;
        z-index: 6;
        display: none;
    }

    .CodeMirror-vscrollbar {
        right: 0px;
        top: 0px;
        overflow: hidden;
    }

    .CodeMirror-hscrollbar {
        bottom: 0px;
        left: 0px;
        overflow: hidden;
    }

    .CodeMirror-scrollbar-filler {
        right: 0px;
        bottom: 0px;
    }

    .CodeMirror-gutter-filler {
        left: 0px;
        bottom: 0px;
    }

    .CodeMirror-gutters {
        position: absolute;
        left: 0px;
        top: 0px;
        padding-bottom: 30px;
        z-index: 3;
    }

    .CodeMirror-gutter {
        white-space: normal;
        height: 100%;
        box-sizing: content-box;
        padding-bottom: 30px;
        margin-bottom: -32px;
        display: inline-block;
    }

    .CodeMirror-gutter-wrapper {
        position: absolute;
        z-index: 4;
        background: 0px 0px !important;
        border: none !important;
    }

    .CodeMirror-gutter-background {
        position: absolute;
        top: 0px;
        bottom: 0px;
        z-index: 4;
    }

    .CodeMirror-gutter-elt {
        position: absolute;
        cursor: default;
        z-index: 4;
    }

    .CodeMirror-lines {
        cursor: text;
    }

    .CodeMirror pre {
        border-radius: 0px;
        border-width: 0px;
        background: 0px 0px;
        font-family: inherit;
        font-size: inherit;
        margin: 0px;
        white-space: pre;
        word-wrap: normal;
        color: inherit;
        z-index: 2;
        position: relative;
        overflow: visible;
    }

    .CodeMirror-wrap pre {
        word-wrap: break-word;
        white-space: pre-wrap;
        word-break: normal;
    }

    .CodeMirror-code pre {
        border-right: 30px solid transparent;
        width: fit-content;
    }

    .CodeMirror-wrap .CodeMirror-code pre {
        border-right: none;
        width: auto;
    }

    .CodeMirror-linebackground {
        position: absolute;
        left: 0px;
        right: 0px;
        top: 0px;
        bottom: 0px;
        z-index: 0;
    }

    .CodeMirror-linewidget {
        position: relative;
        z-index: 2;
        overflow: auto;
    }

    .CodeMirror-wrap .CodeMirror-scroll {
        overflow-x: hidden;
    }

    .CodeMirror-measure {
        position: absolute;
        width: 100%;
        height: 0px;
        overflow: hidden;
        visibility: hidden;
    }

    .CodeMirror-measure pre {
        position: static;
    }

    .CodeMirror div.CodeMirror-cursor {
        position: absolute;
        visibility: hidden;
        border-right: none;
        width: 0px;
    }

    .CodeMirror div.CodeMirror-cursor {
        visibility: hidden;
    }

    .CodeMirror-focused div.CodeMirror-cursor {
        visibility: inherit;
    }

    .cm-searching {
        background: rgba(255, 255, 0, 0.4);
    }

    @media print {
        .CodeMirror div.CodeMirror-cursor {
            visibility: hidden;
        }
    }

    :root {
        --side-bar-bg-color: #fafafa;
        --control-text-color: #777;
    }

    @font-face {
        font-family: "Open Sans";
        font-style: normal;
        font-weight: normal;
        src: local("Open Sans Regular"), url("./github/400.woff") format("woff");
    }

    @font-face {
        font-family: "Open Sans";
        font-style: italic;
        font-weight: normal;
        src: local("Open Sans Italic"), url("./github/400i.woff") format("woff");
    }

    @font-face {
        font-family: "Open Sans";
        font-style: normal;
        font-weight: bold;
        src: local("Open Sans Bold"), url("./github/700.woff") format("woff");
    }

    @font-face {
        font-family: "Open Sans";
        font-style: italic;
        font-weight: bold;
        src: local("Open Sans Bold Italic"), url("./github/700i.woff") format("woff");
    }

    html {
        font-size: 16px;
    }

    body {
        font-family: "Open Sans", "Clear Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
        color: rgb(51, 51, 51);
        line-height: 1.6;
    }

    #write {
        max-width: 860px;
        margin: 0px auto;
        padding: 20px 30px 100px;
    }

    #write > ul:first-child, #write > ol:first-child {
        margin-top: 30px;
    }

    body > :first-child {
        margin-top: 0px !important;
    }

    body > :last-child {
        margin-bottom: 0px !important;
    }

    a {
        color: rgb(65, 131, 196);
    }

    h1, h2, h3, h4, h5, h6 {
        position: relative;
        margin-top: 1rem;
        margin-bottom: 1rem;
        font-weight: bold;
        line-height: 1.4;
        cursor: text;
    }

    h1:hover a.anchor, h2:hover a.anchor, h3:hover a.anchor, h4:hover a.anchor, h5:hover a.anchor, h6:hover a.anchor {
        text-decoration: none;
    }

    h1 tt, h1 code {
        font-size: inherit;
    }

    h2 tt, h2 code {
        font-size: inherit;
    }

    h3 tt, h3 code {
        font-size: inherit;
    }

    h4 tt, h4 code {
        font-size: inherit;
    }

    h5 tt, h5 code {
        font-size: inherit;
    }

    h6 tt, h6 code {
        font-size: inherit;
    }

    h1 {
        padding-bottom: 0.3em;
        font-size: 2.25em;
        line-height: 1.2;
        border-bottom: 1px solid rgb(238, 238, 238);
    }

    h2 {
        padding-bottom: 0.3em;
        font-size: 1.75em;
        line-height: 1.225;
        border-bottom: 1px solid rgb(238, 238, 238);
    }

    h3 {
        font-size: 1.5em;
        line-height: 1.43;
    }

    h4 {
        font-size: 1.25em;
    }

    h5 {
        font-size: 1em;
    }

    h6 {
        font-size: 1em;
        color: rgb(119, 119, 119);
    }

    p, blockquote, ul, ol, dl, table {
        margin: 0.8em 0px;
    }

    li > ol, li > ul {
        margin: 0px;
    }

    hr {
        height: 2px;
        padding: 0px;
        margin: 16px 0px;
        background-color: rgb(231, 231, 231);
        border: 0px none;
        overflow: hidden;
        box-sizing: content-box;
    }

    body > h2:first-child {
        margin-top: 0px;
        padding-top: 0px;
    }

    body > h1:first-child {
        margin-top: 0px;
        padding-top: 0px;
    }

    body > h1:first-child + h2 {
        margin-top: 0px;
        padding-top: 0px;
    }

    body > h3:first-child, body > h4:first-child, body > h5:first-child, body > h6:first-child {
        margin-top: 0px;
        padding-top: 0px;
    }

    a:first-child h1, a:first-child h2, a:first-child h3, a:first-child h4, a:first-child h5, a:first-child h6 {
        margin-top: 0px;
        padding-top: 0px;
    }

    h1 p, h2 p, h3 p, h4 p, h5 p, h6 p {
        margin-top: 0px;
    }

    li p.first {
        display: inline-block;
    }

    ul, ol {
        padding-left: 30px;
    }

    ul:first-child, ol:first-child {
        margin-top: 0px;
    }

    ul:last-child, ol:last-child {
        margin-bottom: 0px;
    }

    blockquote {
        border-left: 4px solid rgb(223, 226, 229);
        padding: 0px 15px;
        color: rgb(119, 119, 119);
    }

    blockquote blockquote {
        padding-right: 0px;
    }

    table {
        padding: 0px;
        word-break: initial;
    }

    table tr {
        border-top: 1px solid rgb(223, 226, 229);
        margin: 0px;
        padding: 0px;
    }

    table tr:nth-child(2n), thead {
        background-color: rgb(248, 248, 248);
    }

    table tr th {
        font-weight: bold;
        border-width: 1px 1px 0px;
        border-top-style: solid;
        border-right-style: solid;
        border-left-style: solid;
        border-top-color: rgb(223, 226, 229);
        border-right-color: rgb(223, 226, 229);
        border-left-color: rgb(223, 226, 229);
        border-image: initial;
        border-bottom-style: initial;
        border-bottom-color: initial;
        text-align: left;
        margin: 0px;
        padding: 6px 13px;
    }

    table tr td {
        border: 1px solid rgb(223, 226, 229);
        text-align: left;
        margin: 0px;
        padding: 6px 13px;
    }

    table tr th:first-child, table tr td:first-child {
        margin-top: 0px;
    }

    table tr th:last-child, table tr td:last-child {
        margin-bottom: 0px;
    }

    .CodeMirror-lines {
        padding-left: 4px;
    }

    .code-tooltip {
        box-shadow: rgba(0, 28, 36, 0.3) 0px 1px 1px 0px;
        border-top: 1px solid rgb(238, 242, 242);
    }

    .md-fences, code, tt {
        border: 1px solid rgb(231, 234, 237);
        background-color: rgb(248, 248, 248);
        border-radius: 3px;
        padding: 2px 4px 0px;
        font-size: 0.9em;
    }

    code {
        background-color: rgb(243, 244, 244);
        padding: 0px 4px 2px;
    }

    .md-fences {
        margin-bottom: 15px;
        margin-top: 15px;
        padding: 8px 1em 6px;
    }

    .md-task-list-item > input {
        margin-left: -1.3em;
    }

    @media screen and (min-width: 914px) {
    }

    @media print {
        html {
            font-size: 13px;
        }

        table, pre {
            break-inside: avoid;
        }

        pre {
            word-wrap: break-word;
        }
    }

    .md-fences {
        background-color: rgb(248, 248, 248);
    }

    #write pre.md-meta-block {
        padding: 1rem;
        font-size: 85%;
        line-height: 1.45;
        background-color: rgb(247, 247, 247);
        border: 0px;
        border-radius: 3px;
        color: rgb(119, 119, 119);
        margin-top: 0px !important;
    }

    .mathjax-block > .code-tooltip {
        bottom: 0.375rem;
    }

    .md-mathjax-midline {
        background: rgb(250, 250, 250);
    }

    #write > h3.md-focus::before {
        left: -1.5625rem;
        top: 0.375rem;
    }

    #write > h4.md-focus::before {
        left: -1.5625rem;
        top: 0.285714rem;
    }

    #write > h5.md-focus::before {
        left: -1.5625rem;
        top: 0.285714rem;
    }

    #write > h6.md-focus::before {
        left: -1.5625rem;
        top: 0.285714rem;
    }

    .md-image > .md-meta {
        border-radius: 3px;
        padding: 2px 0px 0px 4px;
        font-size: 0.9em;
        color: inherit;
    }

    .md-tag {
        color: rgb(167, 167, 167);
        opacity: 1;
    }

    .md-toc {
        margin-top: 20px;
        padding-bottom: 20px;
    }

    .sidebar-tabs {
        border-bottom: none;
    }

    #typora-quick-open {
        border: 1px solid rgb(221, 221, 221);
        background-color: rgb(248, 248, 248);
    }

    #typora-quick-open-item {
        background-color: rgb(250, 250, 250);
        border-color: rgb(254, 254, 254) rgb(229, 229, 229) rgb(229, 229, 229) rgb(238, 238, 238);
        border-style: solid;
        border-width: 1px;
    }

    .on-focus-mode blockquote {
        border-left-color: rgba(85, 85, 85, 0.12);
    }

    header, .context-menu, .megamenu-content, footer {
        font-family: "Segoe UI", Arial, sans-serif;
    }

    .file-node-content:hover .file-node-icon, .file-node-content:hover .file-node-open-state {
        visibility: visible;
    }

    .mac-seamless-mode #typora-sidebar {
        background-color: var(--side-bar-bg-color);
    }

    .md-lang {
        color: rgb(180, 101, 77);
    }

    .html-for-mac .context-menu {
        --item-hover-bg-color: #E6F0FE;
    }

    .typora-export p, .typora-export .footnote-line {
        white-space: normal;
    }
    </style>
</head>
<body class='typora-export os-windows'>
<div id='write' class='is-node'><h1><a name='header-n0' class='md-header-anchor '></a>NoveduApi设计</h1>
    <div class='md-toc' mdtype='toc'><p class="md-toc-content"><span class="md-toc-item md-toc-h1" data-ref="n0"><a
            class="md-toc-inner" href="#header-n0">NoveduApi设计</a></span><span class="md-toc-item md-toc-h2"
                                                                               data-ref="n4"><a class="md-toc-inner"
                                                                                                href="#header-n4">Ⅰ 网站根目录</a></span><span
            class="md-toc-item md-toc-h2" data-ref="n6"><a class="md-toc-inner" href="#header-n6">Ⅱ 响应格式</a></span><span
            class="md-toc-item md-toc-h2" data-ref="n12"><a class="md-toc-inner"
                                                            href="#header-n12">Ⅲ 关于登录</a></span><span
            class="md-toc-item md-toc-h2" data-ref="n18"><a class="md-toc-inner"
                                                            href="#header-n18">Ⅳ api目录 </a></span><span
            class="md-toc-item md-toc-h2" data-ref="n111"><a class="md-toc-inner" href="#header-n111">Ⅴ过滤信息</a></span>
    </p></div>
    <p>&nbsp;</p>
    <h2><a name='header-n4' class='md-header-anchor '></a>Ⅰ 网站根目录</h2>
    <p>api.novedu.cn/v1/</p>
    <h2><a name='header-n6' class='md-header-anchor '></a>Ⅱ 响应格式</h2>
    <p>对于所有的请求，响应格式都是一个 JSON 对象。</p>
    <p>一个请求是否成功是由 HTTP 状态码标明的。一个 2XX 的状态码表示成功，而一个 4XX 表示请求失败。当一个请求失败时响应的主体仍然是一个 JSON 对象，但是总是会包含 <code>code</code> 和
        <code>msg</code> 这两个字段，你可以用它们来进行调试。</p>
    <pre spellcheck="false" class="md-fences md-end-block md-fences-with-lineno ty-contain-cm modeLoaded" lang="json"><div
            class="CodeMirror cm-s-inner CodeMirror-wrap" lang="json"><div
            style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 0px; left: 36px;"><textarea
            autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0"
            style="position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; outline: none;"></textarea></div><div
            class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler"
                                                                                 cm-not-content="true"></div><div
            class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer"
                                                         style="margin-left: 28px; margin-bottom: 0px; border-right-width: 0px; padding-right: 0px; padding-bottom: 0px;"><div
            style="position: relative; top: 0px;"><div class="CodeMirror-lines" role="presentation"><div
            role="presentation" style="position: relative; outline: none;"><div class="CodeMirror-measure"></div><div
            class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div
            class="CodeMirror-code" role="presentation" style=""><div class="CodeMirror-activeline"
                                                                      style="position: relative;"><div
            class="CodeMirror-activeline-background CodeMirror-linebackground"></div><div
            class="CodeMirror-gutter-background CodeMirror-activeline-gutter" style="left: -28px; width: 28px;"></div><div
            class="CodeMirror-gutter-wrapper CodeMirror-activeline-gutter" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">1</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">{</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">2</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span
            class="cm-string cm-property">"meta"</span>:{</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">3</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span
            class="cm-string cm-property">"code"</span>:<span class="cm-number">404</span></span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">4</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span
            class="cm-string">"success"</span>: <span class="cm-atom">false</span>,</span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">5</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span
            class="cm-string">"msg"</span>: <span class="cm-string">"service exception"</span></span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">6</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp;  },</span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">7</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span
            class="cm-string cm-property">"data"</span>:{}</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">8</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">}</span></pre></div></div></div></div></div></div><div
            style="position: absolute; height: 0px; width: 1px; border-bottom: 0px solid transparent; top: 181px;"></div><div
            class="CodeMirror-gutters" style="height: 181px;"><div class="CodeMirror-gutter CodeMirror-linenumbers"
                                                                   style="width: 27px;"></div></div></div></div></pre>
    <p>成功状态下：</p>
    <pre spellcheck="false" class="md-fences md-end-block md-fences-with-lineno ty-contain-cm modeLoaded" lang="json"><div
            class="CodeMirror cm-s-inner CodeMirror-wrap" lang="json"><div
            style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 0px; left: 36px;"><textarea
            autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0"
            style="position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; outline: none;"></textarea></div><div
            class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler"
                                                                                 cm-not-content="true"></div><div
            class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer"
                                                         style="margin-left: 28px; margin-bottom: 0px; border-right-width: 0px; padding-right: 0px; padding-bottom: 0px;"><div
            style="position: relative; top: 0px;"><div class="CodeMirror-lines" role="presentation"><div
            role="presentation" style="position: relative; outline: none;"><div class="CodeMirror-measure"><pre><span>xxxxxxxxxx</span></pre><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt"><div>8</div></div></div><div
            class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div
            class="CodeMirror-code" role="presentation" style=""><div class="CodeMirror-activeline"
                                                                      style="position: relative;"><div
            class="CodeMirror-activeline-background CodeMirror-linebackground"></div><div
            class="CodeMirror-gutter-background CodeMirror-activeline-gutter" style="left: -28px; width: 28px;"></div><div
            class="CodeMirror-gutter-wrapper CodeMirror-activeline-gutter" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">1</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">{</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">2</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span
            class="cm-string cm-property">"meta"</span>:{</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">3</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span
            class="cm-string cm-property">"code"</span>:<span class="cm-number">200</span></span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">4</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span
            class="cm-string">"success"</span>: <span class="cm-atom">true</span>,</span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">5</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span
            class="cm-string">"msg"</span>: <span class="cm-string">"ok"</span></span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">6</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp;  },</span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">7</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span
            class="cm-string cm-property">"data"</span>:{}</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">8</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">}</span></pre></div></div></div></div></div></div><div
            style="position: absolute; height: 0px; width: 1px; border-bottom: 0px solid transparent; top: 181px;"></div><div
            class="CodeMirror-gutters" style="height: 181px;"><div class="CodeMirror-gutter CodeMirror-linenumbers"
                                                                   style="width: 27px;"></div></div></div></div></pre>
    <h2><a name='header-n12' class='md-header-anchor '></a>Ⅲ 关于登录</h2>
    <p>登录 /login POST, data:</p>
    <pre spellcheck="false" class="md-fences md-end-block md-fences-with-lineno ty-contain-cm modeLoaded" lang="json"><div
            class="CodeMirror cm-s-inner CodeMirror-wrap" lang="json"><div
            style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 0px; left: 36px;"><textarea
            autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0"
            style="position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; outline: none;"></textarea></div><div
            class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler"
                                                                                 cm-not-content="true"></div><div
            class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer"
                                                         style="margin-left: 28px; margin-bottom: 0px; border-right-width: 0px; padding-right: 0px; padding-bottom: 0px;"><div
            style="position: relative; top: 0px;"><div class="CodeMirror-lines" role="presentation"><div
            role="presentation" style="position: relative; outline: none;"><div class="CodeMirror-measure"><pre><span>xxxxxxxxxx</span></pre><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt"><div>3</div></div></div><div
            class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div
            class="CodeMirror-code" role="presentation"><div class="CodeMirror-activeline" style="position: relative;"><div
            class="CodeMirror-activeline-background CodeMirror-linebackground"></div><div
            class="CodeMirror-gutter-background CodeMirror-activeline-gutter" style="left: -28px; width: 28px;"></div><div
            class="CodeMirror-gutter-wrapper CodeMirror-activeline-gutter" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">1</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">{</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">2</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span
            class="cm-string cm-property">"username"</span>:<span class="cm-string">"max"</span>,<span
            class="cm-string cm-property">"password"</span>:<span
            class="cm-string">"32@ds*@&amp;dsa"</span></span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">3</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">}</span></pre></div></div></div></div></div></div><div
            style="position: absolute; height: 0px; width: 1px; border-bottom: 0px solid transparent; top: 68px;"></div><div
            class="CodeMirror-gutters" style="height: 68px;"><div class="CodeMirror-gutter CodeMirror-linenumbers"
                                                                  style="width: 27px;"></div></div></div></div></pre>
    <p>返回结果</p>
    <pre spellcheck="false" class="md-fences md-end-block md-fences-with-lineno ty-contain-cm modeLoaded" lang="json"><div
            class="CodeMirror cm-s-inner CodeMirror-wrap" lang="json"><div
            style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 0px; left: 36px;"><textarea
            autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0"
            style="position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; outline: none;"></textarea></div><div
            class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler"
                                                                                 cm-not-content="true"></div><div
            class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer"
                                                         style="margin-left: 28px; margin-bottom: 0px; border-right-width: 0px; padding-right: 0px; padding-bottom: 0px;"><div
            style="position: relative; top: 0px;"><div class="CodeMirror-lines" role="presentation"><div
            role="presentation" style="position: relative; outline: none;"><div class="CodeMirror-measure"><pre><span>xxxxxxxxxx</span></pre><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt"><div>4</div></div></div><div
            class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div
            class="CodeMirror-code" role="presentation"><div class="CodeMirror-activeline" style="position: relative;"><div
            class="CodeMirror-activeline-background CodeMirror-linebackground"></div><div
            class="CodeMirror-gutter-background CodeMirror-activeline-gutter" style="left: -28px; width: 28px;"></div><div
            class="CodeMirror-gutter-wrapper CodeMirror-activeline-gutter" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">1</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">{</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">2</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span
            class="cm-string cm-property">"token"</span>:<span
            class="cm-string">"qmdj8pdidnmyzp0c7yqil91oc"</span>,</span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">3</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span
            class="cm-meta">...</span></span></pre></div><div style="position: relative;"><div
            class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">4</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">}</span></pre></div></div></div></div></div></div><div
            style="position: absolute; height: 0px; width: 1px; border-bottom: 0px solid transparent; top: 91px;"></div><div
            class="CodeMirror-gutters" style="height: 91px;"><div class="CodeMirror-gutter CodeMirror-linenumbers"
                                                                  style="width: 27px;"></div></div></div></div></pre>
    <p>之后发送请求时在header中加入 X-NOV-TOKEN: eyJhbGciOiJIUzI1NiJ9.xxx用于用户验证。</p>
    <h2><a name='header-n18' class='md-header-anchor '></a>Ⅳ api目录 </h2>
    <p>省略版本号</p>
    <ul>
        <li><p>用户相关</p>
            <ul>
                <li>/auth/login POST 用户登录</li>
                <li>/auth/register POST 用户注册</li>
                <li>/auth/change-password POST 修改用户密码</li>
                <li>/users 用户信息</li>
            </ul>
        </li>
        <li><p>课程信息(包括课程基本信息，教学大纲，教师信息)</p>
            <ul>
                <li>/classes GET 获取所有课程信息</li>
                <li>/classes/:id GET 获取指定课程信息</li>
            </ul>
        </li>
        <li><p>课程组队</p>
            <ul>
                <li>/classes/:id/teams GET 获取所有队伍信息（支持过滤信息）</li>
                <li>/teams/:id GET 获取指定队伍信息</li>
                <li>/classes/:id/teams POST 新建一个队伍</li>
                <li>/teams/:id DELETE 删除队伍</li>
                <li>/teams/:id PUT 更新队伍信息</li>
                <li>/teams/:id/request POST 加入某只队伍</li>
                <li>/teams/:id/request GET 获取加入队伍信息</li>
                <li>/teams/:id/request/handler POST 处理请求信息</li>
            </ul>
        </li>
        <li><p>课程论坛</p>
            <ul>
                <li>/bbs/:id/posts GET 获取所有帖子信息(支持过滤信息)</li>
                <li>/posts/:id GET 获取指定帖子信息</li>
                <li>/bbs/:id/posts POST 发布帖子</li>
                <li>/posts/:id PUT 修改帖子(内容,权限)</li>
                <li>/posts/:id DELETE 删除帖子</li>
                <li>/posts/:id/replies GET 获取所有帖子回复(支持过滤信息)</li>
                <li>/posts/:id/replies POST 发布回帖</li>
                <li>/replies/:reply_id DELETE 删除回帖</li>
                <li>/replies/:reply-id/comments GET 获得评论</li>
                <li>/replies/:reply-id/comments POST 发布评论</li>
                <li>/comments/:comment-id DELETE 删除评论</li>
                <li>/bbs/:id POST 修改论坛设置</li>
                <li>/bbs/:id/query?q=xxx GET 搜索主题帖(支持过滤信息)</li>
            </ul>
        </li>
        <li><p>课程资料</p>
            <ul>
                <li>/classes/:id/resources GET 获取课程资源列表(支持过滤信息)</li>
                <li>/classes/:id/resources/:id GET 获取课程资源详细信息</li>
                <li>/classes/:id/resources POST 添加课程资源</li>
                <li>/classes/:id/resources/:id DELETE 删除资源</li>
            </ul>
        </li>
        <li><p>消息系统</p>
            <ul>
                <li>/messages GET 消息列表 获取消息列表(支持过滤信息)</li>
                <li>/messages/:id GET 获得指定消息信息</li>
                <li>/messages/:id POST 响应消息</li>
                <li>/messages/:id DELETE 删除消息</li>
                <li></li>
            </ul>
        </li>
    </ul>
    <h2><a name='header-n111' class='md-header-anchor '></a>Ⅴ过滤信息</h2>
    <pre spellcheck="false" class="md-fences md-end-block md-fences-with-lineno ty-contain-cm modeLoaded" lang=""><div
            class="CodeMirror cm-s-inner CodeMirror-wrap" lang=""><div
            style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 0px; left: 36px;"><textarea
            autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0"
            style="position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; outline: none;"></textarea></div><div
            class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler"
                                                                                 cm-not-content="true"></div><div
            class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer"
                                                         style="margin-left: 28px; margin-bottom: 0px; border-right-width: 0px; padding-right: 0px; padding-bottom: 0px;"><div
            style="position: relative; top: 0px;"><div class="CodeMirror-lines" role="presentation"><div
            role="presentation" style="position: relative; outline: none;"><div class="CodeMirror-measure"><pre><span>xxxxxxxxxx</span></pre><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt"><div>4</div></div></div><div
            class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div
            class="CodeMirror-code" role="presentation"><div class="CodeMirror-activeline" style="position: relative;"><div
            class="CodeMirror-activeline-background CodeMirror-linebackground"></div><div
            class="CodeMirror-gutter-background CodeMirror-activeline-gutter" style="left: -28px; width: 28px;"></div><div
            class="CodeMirror-gutter-wrapper CodeMirror-activeline-gutter" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">1</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">?limit=10：指定返回记录的数量</span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">2</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;">?offset=10：指定返回记录的开始位置。</span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 19px;">3</div></div><pre
            class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;">?page=2&amp;per_page=100：指定第几页，以及每页的记录数。</span></pre></div><div
            style="position: relative;"><div class="CodeMirror-gutter-wrapper" style="left: -28px;"><div
            class="CodeMirror-linenumber CodeMirror-gutter-elt CodeMirror-linenumber-show"
            style="left: 0px; width: 19px;">4</div></div><pre class=" CodeMirror-line " role="presentation"><span
            role="presentation" style="padding-right: 0.1px;">?orderby=name&amp;order=asc：指定返回结果按照哪个属性排序，以及排序顺序。</span></pre></div></div></div></div></div></div><div
            style="position: absolute; height: 0px; width: 1px; border-bottom: 0px solid transparent; top: 113px;"></div><div
            class="CodeMirror-gutters" style="height: 113px;"><div class="CodeMirror-gutter CodeMirror-linenumbers"
                                                                   style="width: 27px;"></div></div></div></div></pre>
    <p>&nbsp;</p>
    <p>&nbsp;</p></div>
</body>
</html>