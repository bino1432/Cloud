"use server"

async function createTasks(a: FormData) {
    const formData = Object.fromEntries(a);
        const name = formData.nome
        const response = await fetch('http://springboot-demo:8088/aws/task', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ nome: name })
        });
}

export default createTasks;