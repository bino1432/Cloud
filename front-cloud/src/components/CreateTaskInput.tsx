import createTasks from "@/app/api/componentApi";

export default function CreateTaskInput() {

    async function createTask(a: FormData){
        createTasks(a);
    }

    return (
        <div>
            <form action={createTask}
            className="flex place-content-center gap-3 my-10">
                <input
                    name="nome"
                    className="bg-green-300 h-10 border-2 border-green-600 rounded-lg"
                    placeholder="Insira o nome da tarefa"
                    type="text" />
                <input
                className="content-center text-neutral-100 text-xl border-2 border-green-800 
                rounded-xl bg-green-700 ease-in-out duration-300 hover:bg-green-800 h-10 w-24"
                type="submit"/>
            </form>
        </div>
    );
}