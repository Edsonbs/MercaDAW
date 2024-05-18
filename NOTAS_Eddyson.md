# Hacks para facilitar la vida:

Si estás codificando, y te das cuenta que lo has hecho por ejemplo en "develop", en vez de en tu rama feature, puedes usar los siguientes pasos para commitear:
- Ejecuta el comando `git stash` para guardar los cambios que has hecho a parte.
- Ahora puedes hacer:
    - `git pull`
    - `git flow feature start NOMBRE_RAMA`
- Una vez estás en tu rama feature, utilizas el `git stash apply` para recuperar los cambios que habías guardado a parte.

Finalmente sólo tienes hacer lo de siempre, `add`, `commit`, `finish` y `push`.

Con esto finalmente habremos hecho commit desde nuestra rama feature y habremos mergeado y pusheado la rama develop.