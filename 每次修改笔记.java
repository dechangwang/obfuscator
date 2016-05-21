JCClassDecl classDecl  = env.enclClass;
        JCMethodDecl methodDecl = null;
        for (JCTree tree : classDecl.defs) {
            if (tree instanceof JCMethodDecl
                    && ((JCMethodDecl) tree).name.toString().equals("main")) {
                methodDecl = ((JCMethodDecl) tree);
            }
        }
        
        Table table = classDecl.name.table;	        
        Name name =  table.fromString("j");	        
        Symtab symtab = Symtab.instance(context);
		VarSymbol sym = new VarSymbol(0,name, symtab.intType,methodDecl.sym);			//此处应该使用method的 即symbol owner应该是所添加的method
		TreeMaker maker = TreeMaker.instance(context);			
		JCVariableDecl vardef = maker.VarDef(sym, maker.Literal(1));			
		methodDecl.body.stats = methodDecl.body.stats.append(vardef);
				
		
		JCIdent ident = maker.Ident(sym);
		JCLiteral literal = maker.Literal(9);
		
		
		
		OperatorSymbol mulSymbol = (OperatorSymbol) CallResolve.ResolveBinary(context, env, JCTree.Tag.MUL, literal.type, literal.type);
		JCBinary binary = maker.Binary(JCTree.Tag.MUL, literal, literal);
		binary.operator = mulSymbol;
//		binary.type = mulSymbol.type;
		binary.type = mulSymbol.type.getReturnType();

		JCAssign assign = maker.Assign(maker.Ident(sym), binary);
		methodDecl.body.stats = methodDecl.body.stats.append(maker.Exec(assign));
		
		JCStatement s;
		JCExpressionStatement ss;
		System.out.println(env.toplevel);
