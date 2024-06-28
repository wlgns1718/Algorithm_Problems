# [Gold V] NIZOVI - 11954 

[문제 링크](https://www.acmicpc.net/problem/11954) 

### 성능 요약

메모리: 14268 KB, 시간: 136 ms

### 분류

구현, 파싱, 문자열

### 제출 일자

2024년 6월 28일 15:40:30

### 문제 설명

<p>An array in a certain programming language is defined in the following way:</p>

<ul>
	<li>The beginning and the end of an array is denoted by an open and closed curly bracket, respectively.</li>
	<li>Inside the curly braces, there are (possibly even 0) values separated by a comma (there is no comma after the last value in the array).</li>
	<li>Each value can be a word (an array of lowercase letters of the English alphabet) or another array.</li>
	<li>Examples of correctly defined arrays are: {}, {a,b,c}, {abc,znj,{novi,niz},pozz}.</li>
</ul>

<p>Recently, you’ve noticed that the programming language does not throw an error if you do not place the appropriate number of spaces and new lines before or after the curly braces or the commas. Given the fact that you too mind the values being so „squished“ together, you’ve decided to get to work and modify the shape of the array in the following way:</p>

<ul>
	<li>Each value that is not an array or denotes the beginning or the end of the array (curly braces) will be in its own line.</li>
	<li>The commas are „connected“ with the value located directly before them and there is a new line after each comma.</li>
	<li>After the curly bracket denoting the beginning of the array, the indentation of the content increases (shifting the output to the right) for 2 spaces.</li>
	<li>Before the curly bracket denoting the end of the array ’}’, the indentation of the content decreases (shifting the output to the left) for 2 spaces.</li>
</ul>

### 입력 

 <p>The first line of input contains an array of characters S (1 ≤ |S| ≤ 1500), representing the array from the task.</p>

### 출력 

 <p>The output must consist of the modified version of the array from the task.</p>

