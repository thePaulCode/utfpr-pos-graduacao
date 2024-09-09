<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CRUD Cidades</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

    <div class="container-fluid">
        <div class="jumbotron mt-5">
            <h1>GERENCIAMENTO DE CIDADES</h1>
            <p>UM CRUD PARA CRIAR, ALTERAR, EXCLUIR E LISTAR CIDADES</p>
        </div>

        <form>
            <div class="form-group">
                <label for="nome">Cidade:</label>
                <input type="text" class="form-control" placeholder="Informe o nome da cidade" id="nome">
            </div>

            <div class="form-group">
                <label for="nome">Estado:</label>
                <input type="text" class="form-control" placeholder="Informe o estado ao qual a cidade pertence"
                       id="estado">
            </div>
            <button type="submit" class="btn btn-primary">CRIAR</button>
            <table class="table table-striped table-hover mt-5">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Estado</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <#list listaCidades as cidade>
                        <tr>
                            <td>${cidade.nome}</td>
                            <td>${cidade.estado}</td>
                            <td>
                                <div class="d-flex d-justify-content-center">
                                    <a class="btn btn-warning mr-3">ALTERAR</a>
                                    <a class="btn btn-danger">EXCLUIR</a>

                                </div>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>

        </form>
    </div>

</body>
</html>