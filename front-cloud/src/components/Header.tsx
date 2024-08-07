'use client';

export default function Header() {
    return (
        <header className="bg-green-600 h-16 content-center px-16">
            <div className=" flex space-x-4">
                <div className="text-neutral-100 text-3xl w-full">
                    <a href="/">Cloud Images</a>
                </div>
                <div className="content-center text-neutral-100 text-xl border-2 border-green-800 
                rounded-xl bg-green-700 ease-in-out duration-300 hover:bg-green-800">
                    <a className="p-3" href="/tarefas">Tarefas</a>
                </div>
            </div>
        </header>
    );
}